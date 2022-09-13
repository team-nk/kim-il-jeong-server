package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtMalformedException : KimIlJeongException(ErrorCode.MALFORMED_JWT) {
    val EXCEPTION = JwtMalformedException
}
