package com.example.kimiljeongserver.global.config

import com.example.kimiljeongserver.global.error.ErrorHandlingFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(AuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ErrorHandlingFilter(), AuthenticationFilter::class.java)
    }
}