package com.example.kimiljeongserver.global.error

import com.cheajib.cheajibserver.global.error.exception.InternalServerError
import com.example.kimiljeongdomain.error.KimIlJeongException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorHandlingFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e) {
                is KimIlJeongException -> writeErrorCode(e, response)
                else -> writeErrorCode(InternalServerError.EXCEPTION, response)
            }
        }
    }

    private fun writeErrorCode(exception: KimIlJeongException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)

        response.status = errorResponse.errorStatus
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}
