package com.example.kimiljeongserver.global.error

import com.example.kimiljeongdomain.error.ErrorCode

class ErrorResponse(errorCode: ErrorCode) {

    private val status: Int = errorCode.status
    private val code: String = errorCode.code
    private val message: String = errorCode.message

    override fun toString(): String {
        return "{\n" +
                "\t\"status\": " + status +
                ",\t\"code\": \"" + code + '\"' +
                ",\t\"message\": \"" + message + '\"' +
                "\n}";
    }
}