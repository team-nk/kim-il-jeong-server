package com.example.kimiljeongdomain.error

enum class ErrorCode(val status: Int, val code: String, val message: String) {

    INVALID_SERVER_ERROR(500, "GLOBAL-500-1", "Invalid Server Error")
}