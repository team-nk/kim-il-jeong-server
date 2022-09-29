package team.nk.kimiljeongserver.global.filter

import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import team.nk.kimiljeongserver.global.error.ErrorProperty
import team.nk.kimiljeongserver.global.error.ErrorResponse
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException
import team.nk.kimiljeongserver.global.exception.InternalServerErrorException
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when(e) {
                is KimIlJeongException -> errorToJson(e.errorProperty, response)
                else -> {
                    errorToJson(InternalServerErrorException.EXCEPTION.errorProperty, response)
                    e.printStackTrace()
                }
            }
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(ErrorResponse(errorProperty.status(), errorProperty.message()).toString())
    }
}