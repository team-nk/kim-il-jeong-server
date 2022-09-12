package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtValidateFailedException private constructor() : KimIlJeongException(ErrorCode.VALIDATE_FAILED_JWT) {

    companion object {
        @JvmField
        val EXCEPTION = JwtValidateFailedException()
    }
}