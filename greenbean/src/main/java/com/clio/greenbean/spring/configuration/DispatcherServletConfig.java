package com.clio.greenbean.spring.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.clio",
    includeFilters={
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..controller..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..view..*")
    }
)
public class DispatcherServletConfig implements WebMvcConfigurer,ApplicationContextAware {
    
    @Value("${picturesPath}")
    private String picturesPath;
    
    private ApplicationContext applicationContext;
    /**
     * 声明模板解析器bean
     *ITemplateResolver is a interface
     * @return SpringResourceTemplateResolver模板解析器
     */
    @Bean
    public ITemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("classpath:/template/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    
    /**
     * 声明模板引擎
     * @return SpringTemplateEngne 模板引擎
     */
    @Bean
    public ISpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
    
    /**
     * 声明视图解析器
     * @return ThymeleafViewResolver
     */
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("utf-8");
        return viewResolver;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/common/**").addResourceLocations("classpath:/common/");
        registry.addResourceHandler("/static/template/**").addResourceLocations("classpath:/template/");
        registry.addResourceHandler("/static/pic/**").addResourceLocations("classpath:/pic/");
        String homePath = System.getProperty("user.home").replace("\\", "/");
        String path = "file:" + homePath + picturesPath;
        registry.addResourceHandler("/static/picture/**").addResourceLocations(path);
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Charset utf8Charset = StandardCharsets.UTF_8;
        StringHttpMessageConverter converter = new StringHttpMessageConverter(utf8Charset);
        converters.add(converter);
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
