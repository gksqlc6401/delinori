package com.noriteo.delinori.security.config;

import com.noriteo.delinori.security.hendler.CustomAccessDeniedHandler;
import com.noriteo.delinori.security.hendler.CustomAuthenticationEntryPoint;
import com.noriteo.delinori.security.hendler.CustomLoginSuccessHandler;
import com.noriteo.delinori.security.service.CustomUserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = "com.noriteo.delinori.security.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.security.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private MemberMapper memberMapper;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//패스워드 인코딩을 해줬다(복잡하게 만들어줬다)
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/board/doAll").permitAll()
//                .antMatchers("/board/doNori").access("hasRole('ROLE_NORI')")
//                .antMatchers("/board/doDeli").access("hasRole('ROLE_DELI')")
//                .antMatchers("/board/doAdmin").access("hasRole('ROLE_ADMIN')");
        http.formLogin().loginPage("/customLogin")
                .loginProcessingUrl("/login");

        http.csrf().disable();//disable을 하면 따로 로그아웃을 만들어줄 필요가 없다.

        http.rememberMe().tokenRepository(persistentTokenRepository())
                .key("noriteo").tokenValiditySeconds(60*60*24*30);
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler(){

        return new CustomAccessDeniedHandler();
    }

    @Bean
    public CustomAuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler() {

        return new CustomLoginSuccessHandler();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService);

//        auth.inMemoryAuthentication().withUser("deli1").password("$2a$10$ISQki5FQkZuBUgYq6HRQBOUNHI4wQmPvUe0YbsIGItl9k2Ar0r0vy")
//                .roles("DELI");
//        auth.inMemoryAuthentication().withUser("nori1").password("$2a$10$ISQki5FQkZuBUgYq6HRQBOUNHI4wQmPvUe0YbsIGItl9k2Ar0r0vy")
//                .roles("NORI");
//        auth.inMemoryAuthentication().withUser("admin1").password("$2a$10$ISQki5FQkZuBUgYq6HRQBOUNHI4wQmPvUe0YbsIGItl9k2Ar0r0vy")
//                .roles("DELI","NORI","ADMIN");
    }

//    @Bean
//     public CustomUserDetailsService customUserDetailsService() {
//        return new CustomUserDetailsService(memberMapper);
//    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }
}
