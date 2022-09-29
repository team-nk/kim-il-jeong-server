package team.nk.kimiljeongserver.global.security

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import team.nk.kimiljeongserver.global.filter.ExceptionFilter
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenFilter
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenResolver

class FilterConfig(
    private val jwtTokenResolver: JwtTokenResolver,
    private val jwtTokenProvider: JwtTokenProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(
            JwtTokenFilter(jwtTokenResolver, jwtTokenProvider),
            UsernamePasswordAuthenticationFilter::class.java
        )
        builder.addFilterBefore(
            ExceptionFilter(), JwtTokenFilter::class.java
        )
    }
}