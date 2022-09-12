package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class JwtSignatureException private constructor() : KimIlJeongException(ErrorCode.SIGNATURE_JWT) {

    companion object {
        val EXCEPTION = JwtSignatureException()
    }
}