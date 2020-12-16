package com.photoapp.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Enviroment;
import org.springframework.security.config.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    public WebSecurity(Enviroment enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequest()
        .antMatchers( environment.getProperty("api.h2console.url.path")).permitAll()
        .antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
        .antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new AuthorizationFilter(AuthenticationManager(), environment));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}