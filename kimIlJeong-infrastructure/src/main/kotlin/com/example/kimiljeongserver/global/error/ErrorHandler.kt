package com.example.kimiljeongserver.global.error

import com.example.kimiljeongdomain.error.ErrorCode
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleBindException(exception: BindException): ErrorResponse? {
        return ErrorResponse.of(exception.bindingResult)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException
    ): ErrorResponse? {
        return ErrorResponse.of(exception.bindingResult)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleConstraintViolationException(
        exception: ConstraintViolationException
    ): ErrorResponse? {
        return ErrorResponse.of(exception.constraintViolations)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleDataIntegrityViolationException(
        exception: DataIntegrityViolationException
    ): ErrorResponse? {
        return ErrorResponse.of(exception)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleIllegalArgumentException(
        exception: java.lang.IllegalArgumentException
    ): ErrorResponse? {
        return ErrorResponse.of(ErrorCode.BAD_REQUEST)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected fun handleHttpRequestMethodNotSupportException(
        exception: MethodArgumentNotValidException
    ): ErrorResponse? {
        return ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED)
    }
}