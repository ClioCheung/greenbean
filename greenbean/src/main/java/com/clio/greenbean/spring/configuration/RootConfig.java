package com.clio.greenbean.spring.configuration;

import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Configuration
@PropertySource("classpath:properties/database.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.clio",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..service..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..component..*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern = "com.clio..repository..*")
    }
)
public class RootConfig {
    
    @Value("#{${greenbean.db}}")
    private Map<String, String> databaseProperties;
    
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(databaseProperties.get("driverClassName"));
        dataSource.setUrl(databaseProperties.get("url"));
        dataSource.setUsername(databaseProperties.get("username"));
        dataSource.setPassword(databaseProperties.get("password"));
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
        myBatisConfig.setLazyLoadingEnabled(true);
        myBatisConfig.setAggressiveLazyLoading(false);
        myBatisConfig.setCacheEnabled(true);
        myBatisConfig.addMappers("com.clio.greenbean.mybatis.mapper");
        sqlSessionFactory.setConfiguration(myBatisConfig);
        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
    
    @Bean
    public UserMapper userMapper() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate.getMapper(UserMapper.class);
    }
}
