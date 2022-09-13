package com.example.kimiljeongserver.global.error

import com.example.kimiljeongdomain.error.KimIlJeongException
import com.example.kimiljeongserver.global.error.exception.CustomDataIntegrityViolationException
import com.example.kimiljeongserver.global.error.exception.CustomIllegalArgumentException
import com.example.kimiljeongserver.global.error.exception.CustomMethodArgumentNotValidException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(org.springframework.validation.BindException::class)
    fun handleBindException(e: org.springframework.validation.BindException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String?> = HashMap()

        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(): ResponseEntity<ErrorResponse<Unit>> {
        return handleException(CustomMethodArgumentNotValidException.EXCEPTION)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(): ResponseEntity<ErrorResponse<Unit>> {
        return handleException(CustomDataIntegrityViolationException.EXCEPTION)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(): ResponseEntity<ErrorResponse<Unit>> {
        return handleException(CustomIllegalArgumentException.EXCEPTION)
    }

    private fun handleException(e: KimIlJeongException): ResponseEntity<ErrorResponse<Unit>> {
        val status = HttpStatus.valueOf(e.errorStatus)
        val body = ErrorResponse.of(e)
        return ResponseEntity(body, status)
    }
}
