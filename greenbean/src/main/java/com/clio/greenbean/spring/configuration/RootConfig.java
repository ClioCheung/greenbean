package com.clio.greenbean.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Configuration
@ComponentScan(basePackages = "com.clio",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..service..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..component..*")
    }
)
public class RootConfig {

}
