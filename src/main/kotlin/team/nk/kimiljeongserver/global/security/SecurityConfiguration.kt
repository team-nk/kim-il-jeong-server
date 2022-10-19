package team.nk.kimiljeongserver.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenParser

@Configuration
class SecurityConfiguration(
    private val jwtTokenParser: JwtTokenParser
) {

    @Throws(Exception::class)
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .cors()

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeHttpRequests()

            .antMatchers("/swagger-ui/**").permitAll()
            .antMatchers("/v3/api-docs/**").permitAll()

            .antMatchers(HttpMethod.POST, "/user").permitAll()
            .antMatchers(HttpMethod.POST, "/user/login").permitAll()
            .anyRequest().authenticated()

        http
            .apply(FilterConfig(jwtTokenParser))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}