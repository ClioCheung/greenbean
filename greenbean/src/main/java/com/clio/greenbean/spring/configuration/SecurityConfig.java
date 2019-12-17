package com.clio.greenbean.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * created by 吾乃逆世之神也 on 2019/10/13
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final String QUERY_USER_SQL = "select username,password,enabled from t_user where username = ?";
    private static final String QUERY_AUTHORITIES_SQL = "select username,authority from t_authority inner join t_user on t_authority.user_id = t_user.id where username = ?";
    
    // @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private DataSource dataSource;
    
    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // FIXME 刷新登录后的signIn页面，登录post请求返回403
        // XXX 需要重构loginPage的url，改为sign
        http.authorizeRequests()
            .antMatchers("/static/common/**","/static/template/**","/signUp","/signUp/*","/about").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/signIn").permitAll()
            .successForwardUrl("/home")
            .failureUrl("/signInError")
            .and().logout().logoutUrl("/signOut").logoutSuccessUrl("/signIn")
            .and().rememberMe().key("greenbean").tokenValiditySeconds(120)
        ;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery(QUERY_USER_SQL)
        .authoritiesByUsernameQuery(QUERY_AUTHORITIES_SQL);
    }
    
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}