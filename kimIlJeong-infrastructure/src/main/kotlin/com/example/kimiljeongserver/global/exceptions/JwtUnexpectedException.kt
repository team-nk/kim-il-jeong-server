package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtUnexpectedException private constructor() : KimIlJeongException(ErrorCode.UNEXPECTED_JWT) {

    companion object {
        @JvmField
        val EXCEPTION = JwtUnexpectedException()
    }
}