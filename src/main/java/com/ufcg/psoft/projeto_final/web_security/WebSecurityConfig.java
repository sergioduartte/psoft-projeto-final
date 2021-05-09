package com.ufcg.psoft.projeto_final.web_security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authTokenFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    private AuthJWTFilter authTokenFilter() throws Exception {
        return new AuthJWTFilter(getApplicationContext());
    }
}
