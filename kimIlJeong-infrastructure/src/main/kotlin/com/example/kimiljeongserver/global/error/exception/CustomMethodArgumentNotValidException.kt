package com.example.kimiljeongserver.global.error.exception

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object CustomMethodArgumentNotValidException : KimIlJeongException(ErrorCode.METHOD_ARGUMENT_NOT_VALID) {
    val EXCEPTION = CustomMethodArgumentNotValidException
}
