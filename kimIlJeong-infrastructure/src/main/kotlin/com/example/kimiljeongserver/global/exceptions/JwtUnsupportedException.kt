package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtUnsupportedException : KimIlJeongException(ErrorCode.UNSUPPORTED_JWT) {
    val EXCEPTION = JwtUnsupportedException
}
