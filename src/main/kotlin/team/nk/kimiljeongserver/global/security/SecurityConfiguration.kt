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
            .formLogin().disable()
            .csrf().disable()
            .cors()

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeHttpRequests()

            .antMatchers("/swagger-ui/**").permitAll()
            .antMatchers("/v3/api-docs/**").permitAll()

            .antMatchers(HttpMethod.GET, "/oauth/google").permitAll()
            .antMatchers(HttpMethod.GET, "/oauth/google/code").permitAll()
            .antMatchers(HttpMethod.GET, "/oauth/kakao").permitAll()
            .antMatchers(HttpMethod.GET, "/oauth/kakao/code").permitAll()
            .antMatchers(HttpMethod.GET, "/oauth/kakao/location/**").permitAll()
            .antMatchers("/code").permitAll()

            .antMatchers(HttpMethod.PUT, "/auth").authenticated()

            .antMatchers(HttpMethod.POST, "/user").permitAll()
            .antMatchers(HttpMethod.GET, "/user").authenticated()
            .antMatchers(HttpMethod.POST, "/user/login").permitAll()
            .antMatchers(HttpMethod.PATCH, "/user/password").authenticated()
            .antMatchers(HttpMethod.PATCH, "/user/birthday").authenticated()
            .antMatchers(HttpMethod.GET, "/user/check/**").permitAll()
            .antMatchers(HttpMethod.GET, "/user/code/**").permitAll()

            .antMatchers(HttpMethod.POST, "/schedule").authenticated()

            .antMatchers(HttpMethod.PUT, "/schedule/{schedule-id}").authenticated()
            .antMatchers(HttpMethod.DELETE, "/schedule/{schedule-id}").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule/{schedule-id}").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule/map").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule/location").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule/list").authenticated()
            .antMatchers(HttpMethod.GET, "/schedule/choose").authenticated()

            .antMatchers(HttpMethod.POST, "/post").authenticated()
            .antMatchers(HttpMethod.GET, "/post").authenticated()
            .antMatchers(HttpMethod.GET, "/post/birthday").authenticated()

            .antMatchers(HttpMethod.GET, "/mail/**").permitAll()
            .antMatchers(HttpMethod.POST, "/image").permitAll()

            .antMatchers(HttpMethod.POST, "/comment/{post-id}").authenticated()
            .antMatchers(HttpMethod.GET, "/comment").authenticated()
                
            .anyRequest().authenticated()

        http
            .apply(FilterConfig(jwtTokenParser))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}