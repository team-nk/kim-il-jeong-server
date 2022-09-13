package com.example.kimiljeongserver.global.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object JwtValidateFailedException : KimIlJeongException(ErrorCode.VALIDATE_FAILED_JWT) {
    val EXCEPTION = JwtValidateFailedException
}
