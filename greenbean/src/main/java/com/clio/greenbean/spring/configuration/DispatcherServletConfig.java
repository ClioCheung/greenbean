package com.clio.greenbean.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Controller
@ComponentScan(basePackages = "com.clio",
    includeFilters={
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..controller..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..view..*")
    }
)
public class DispatcherServletConfig {
   /* @Bean
    public SpringResourceTemplateResolver templateResolver(){
        // SpringResourceTemplateResolver automatically integrates with Spring's own
        // resource resolution infrastructure, which is highly recommended.
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // HTML is the default value, added here for the sake of clarity.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false if you want
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(true);
        return templateResolver;
    }*/
}
