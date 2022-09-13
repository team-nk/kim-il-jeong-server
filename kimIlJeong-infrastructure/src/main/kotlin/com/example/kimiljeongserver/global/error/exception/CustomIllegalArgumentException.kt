package com.example.kimiljeongserver.global.error.exception

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object CustomIllegalArgumentException : KimIlJeongException(ErrorCode.ILLEGAL_ARGUMENT) {
    val EXCEPTION = CustomIllegalArgumentException
}
