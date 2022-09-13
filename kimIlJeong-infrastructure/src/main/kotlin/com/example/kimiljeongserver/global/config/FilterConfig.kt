package com.example.kimiljeongserver.global.config

import com.example.kimiljeongserver.global.error.ErrorHandlingFilter
import com.example.kimiljeongserver.global.security.jwt.JwtTokenFilter
import com.example.kimiljeongserver.global.security.jwt.JwtTokenParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtTokenFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ErrorHandlingFilter(objectMapper), JwtTokenFilter::class.java)
    }
}
