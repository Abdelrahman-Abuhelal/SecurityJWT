//package com.userinsecure.secret.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//        private UserPrincipalDetailsService userPrincipalDetailsService;
//
//    public SecurityConfiguration() {
//    }
//
//    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
//        this.userPrincipalDetailsService = userPrincipalDetailsService;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .anyRequest().fullyAuthenticated()
////                .and()
////                .formLogin();
//        http.
//                authorizeRequests().
//                anyRequest().
//                permitAll();
////        http
////                .authorizeRequests()
//////                .antMatchers("/index.html").permitAll()
//////                .antMatchers("/profile/**").authenticated()
//////                .antMatchers("/admin/**").hasRole("ADMIN")
//////                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
//////                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
//////                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
////                .antMatchers("/api/public/users").permitAll()
////                .antMatchers("/api/public/users/adduser").permitAll()
////                .and()
////                .httpBasic();
//
//    }
//
//
//
//    @Bean
//    DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}