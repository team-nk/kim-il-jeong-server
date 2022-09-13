package com.example.kimiljeongserver.global.error.exception

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object CustomDataIntegrityViolationException : KimIlJeongException(ErrorCode.DATA_INTEGRITY_VIOLATION) {
    val EXCEPTION = CustomDataIntegrityViolationException
}
