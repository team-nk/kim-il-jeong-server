package com.example.kimiljeongserver.global.error

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorHandlingFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: KimIlJeongException) {
            errorToJson(e.errorCode, response)
        } catch (e: Exception) {
            if (e.cause is KimIlJeongException) {
                errorToJson((e.cause as KimIlJeongException).errorCode, response)
            } else {
                e.printStackTrace()
                errorToJson(ErrorCode.INVALID_SERVER_ERROR, response)
            }
        }
    }

    private fun errorToJson(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(ErrorResponse(errorCode).toString())
    }
}

