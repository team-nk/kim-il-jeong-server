package team.nk.kimiljeongserver.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

@RestControllerAdvice
class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): ErrorResponse.BindErrorResponse? = ErrorResponse.of(e)

    @ExceptionHandler(KimIlJeongException::class)
    fun handleGlobalException(exception: KimIlJeongException): ResponseEntity<ErrorResponse> {
        return handleException(exception)
    }

    private fun handleException(e: KimIlJeongException): ResponseEntity<ErrorResponse> {
        val exception = e.errorProperty
        val status = HttpStatus.valueOf(exception.status())
        val body = ErrorResponse.of(exception)
        return ResponseEntity(body, status)
    }
}