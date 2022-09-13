package com.example.kimiljeongserver.global.error

import com.example.kimiljeongdomain.error.KimIlJeongException
import com.fasterxml.jackson.annotation.JsonInclude

class ErrorResponse<T>(
    val errorStatus: Int,
    val errorCode: String,
    val errorMessage: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val content: T?
) {

    companion object {
        fun of(exception: KimIlJeongException): ErrorResponse<Unit> {
            return ErrorResponse(
                errorStatus = exception.errorStatus,
                errorCode = exception.errorCode,
                errorMessage = exception.errorMessage,
                content = null
            )
        }
    }

    override fun toString(): String {
        return "{\n" +
                "\t\"status\": " + errorStatus +
                ",\t\"code\": \"" + errorCode + '\"' +
                ",\t\"message\": \"" + errorMessage + '\"' +
                ",\t\"content\": \"" + content + '\"' +
                "\n}"
    }
}
