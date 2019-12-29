package com.clio.greenbean.web.setting;

import com.clio.greenbean.spring.configuration.DispatcherServletConfig;
import com.clio.greenbean.spring.configuration.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{DispatcherServletConfig.class};
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // TODO 处理路径配置
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }
}
