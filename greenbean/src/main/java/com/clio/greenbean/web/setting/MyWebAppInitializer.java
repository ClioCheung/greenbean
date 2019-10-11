package com.clio.greenbean.web.setting;

import com.clio.greenbean.spring.configuration.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
        return new Class[0];
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
