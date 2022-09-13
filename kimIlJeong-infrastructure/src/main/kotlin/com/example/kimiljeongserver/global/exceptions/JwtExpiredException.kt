package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtExpiredException : KimIlJeongException(ErrorCode.EXPIRED_JWT) {
    val EXCEPTION = JwtExpiredException
}
