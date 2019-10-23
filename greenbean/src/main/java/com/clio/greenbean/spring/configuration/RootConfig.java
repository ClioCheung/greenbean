package com.clio.greenbean.spring.configuration;

import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
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
//      com.mysql.cj.jdbc.Driver 是 mysql-connector-java 6中的 及以上
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//      com.mysql.cj.jdbc.Driver  mysql-connector-java 5中的
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/greenbean");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
       SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
       sqlSessionFactoryBean.setDataSource(dataSource());
       org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
       myBatisConfig.setLazyLoadingEnabled(true);
       myBatisConfig.setAggressiveLazyLoading(false);
       myBatisConfig.setCacheEnabled(true);
       sqlSessionFactoryBean.setConfiguration(myBatisConfig);
    return sqlSessionFactoryBean;
    }
    
    @Bean
    public MapperFactoryBean userMapper() throws Exception {
        MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(UserMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactoryBean().getObject());
        return mapperFactoryBean;
    }
    
}
