package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtMalformedException private constructor() : KimIlJeongException(ErrorCode.MALFORMED_JWT) {

    companion object {
        @JvmField
        val EXCEPTION = JwtMalformedException()
    }
}