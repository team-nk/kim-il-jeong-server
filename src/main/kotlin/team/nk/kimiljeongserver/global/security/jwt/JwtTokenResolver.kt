package team.nk.kimiljeongserver.global.security.jwt

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenResolver {
    companion object {
        private const val JWT_HEADER = "Authorization"
        private const val JWT_PREFIX = "Bearer"
    }

    fun resolveToken(httpServletRequest: HttpServletRequest): String? {
        val bearerToken: String? = httpServletRequest.getHeader(JWT_HEADER)
        return parseToken(bearerToken)
    }

    fun parseToken(token: String?): String? {
        return if (token != null && token.startsWith(JWT_PREFIX)) {
            return token.replace(JWT_PREFIX, "")
        } else null
    }
}