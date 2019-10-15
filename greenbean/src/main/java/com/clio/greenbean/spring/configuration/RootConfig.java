package com.clio.greenbean.spring.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.sql.DataSource;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Configuration
@ComponentScan(basePackages = "com.clio",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..service..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..component..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..repository..*")
    }
)
public class RootConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/greenbean");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
