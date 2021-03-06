package com.clio.greenbean.spring.configuration;

import com.clio.greenbean.mybatis.mapper.BookMapper;
import com.clio.greenbean.mybatis.mapper.MyBookMapper;
import com.clio.greenbean.mybatis.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * created by 吾乃逆世之神也 on 2019/10/11
 */
@Configuration
@PropertySource({
    "classpath:properties/database.properties",
    "classpath:properties/path.properties",
    "classpath:properties/system.properties"
})
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableCaching
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
    
    /**
     * 激活此profile需要在jetty configurations中设置
     *      VM Options: -Dspring.profiles.active=produce
     * @return dataSource
     */
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
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
        myBatisConfig.setLazyLoadingEnabled(true);
        myBatisConfig.setAggressiveLazyLoading(false);
        myBatisConfig.setCacheEnabled(true);
        myBatisConfig.addMappers("com.clio.greenbean.mybatis.mapper");
        sqlSessionFactory.setConfiguration(myBatisConfig);
        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    
    // XXX 创建Mapper类的配置进行统一管理
    @Bean
    public UserMapper userMapper(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate.getMapper(UserMapper.class);
    }
    
    @Bean
    public MyBookMapper myBookMapper(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate.getMapper(MyBookMapper.class);
    }
    
    @Bean
    public BookMapper bookMapper(SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate.getMapper(BookMapper.class);
    }
    
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }
    
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(){
        return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
    }
}
