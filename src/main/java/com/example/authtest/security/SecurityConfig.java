package com.example.authtest.security;

import com.example.authtest.service.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final AppUserDetailsService appUserDetailsService;

    public SecurityConfig(AppUserDetailsService appUserDetailsService) {
        this.appUserDetailsService = appUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Alternativ Argon2, aber Bcrypt ist auch absolut fein!
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/*").permitAll()
                .antMatchers("/api/admin").hasRole("admin")
                .antMatchers("/api/bye").authenticated() //only admin role has access to this link
                .antMatchers("/api/auth").authenticated() //admin and user have access
                .antMatchers("/admin/*").authenticated()
                .and().httpBasic();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Ryan")
//                .password(passwordEncoder().encode("ABC123"))
//                .roles("admin");
//        auth.inMemoryAuthentication()
//                .withUser("Billy")
//                .password(passwordEncoder().encode("ABC321"))
//                .roles("user");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
    }
}
