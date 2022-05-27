package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSicurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountDetailService accountDetailService;

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountDetailService).passwordEncoder(passwordEncoder());
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("admin"))
//                .authorities("ADMIN");
//
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/css/**", "/images/**", "/img/**","/js/**","/lib/**","/scss/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .loginProcessingUrl("/j_spring_security_check")
//                .defaultSuccessUrl("/login_success")
//                .failureUrl("/login_false")
//                .usernameParameter("email")
//                .passwordParameter("pass");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**", "/images/**", "/img/**","/js/**","/lib/**","/scss/**").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/login_success")
                .failureUrl("/login_false")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("email")
                .passwordParameter("pass");
    }
}
