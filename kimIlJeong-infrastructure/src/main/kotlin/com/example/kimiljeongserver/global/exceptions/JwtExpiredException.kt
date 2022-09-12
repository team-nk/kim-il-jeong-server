package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtExpiredException private constructor() : KimIlJeongException(ErrorCode.EXPIRED_JWT) {

    companion object {
        @JvmField
        val EXCEPTION = JwtExpiredException()
    }
}