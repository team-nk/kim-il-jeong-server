package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtSignatureException : KimIlJeongException(ErrorCode.SIGNATURE_JWT) {
    val EXCEPTION = JwtSignatureException
}
