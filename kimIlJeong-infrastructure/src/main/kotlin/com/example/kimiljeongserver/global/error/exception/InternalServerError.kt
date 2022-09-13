package com.cheajib.cheajibserver.global.error.exception

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

object InternalServerError : KimIlJeongException(ErrorCode.INTERNAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerError
}
