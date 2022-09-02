package com.example.kimiljeongdomain.error

class KimIlJeongException(val errorCode: ErrorCode) : RuntimeException() {
    override fun fillInStackTrace(): Throwable {
        return this
    }
}