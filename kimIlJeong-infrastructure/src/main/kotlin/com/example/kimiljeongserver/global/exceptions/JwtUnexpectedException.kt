package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtUnexpectedException : KimIlJeongException(ErrorCode.UNEXPECTED_JWT) {
    val EXCEPTION = JwtUnexpectedException
}
