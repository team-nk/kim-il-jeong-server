package com.example.kimiljeongserver.global.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfiguration() {

    override fun configure(http: HttpSecurity) {
        http
                .formLogin().disable()
                .csrf().disable()
                .cors()
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
                .authorizeRequests()
                .antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(FilterConfig())

    }
}