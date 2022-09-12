package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtUnsupportedException private constructor() : KimIlJeongException(ErrorCode.UNSUPPORTED_JWT) {

    companion object {
        @JvmField
        val EXCEPTION = JwtUnsupportedException()
    }
}