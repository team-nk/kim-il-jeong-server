package com.example.kimiljeongdomain.error

open class KimIlJeongException(
    private val exceptionProperty: ErrorProperty
) : RuntimeException() {

    val errorStatus: Int
        get() = exceptionProperty.errorStatus

    val errorCode: String
        get() = exceptionProperty.errorCode

    val errorMessage: String
        get() = exceptionProperty.errorMessage

    override fun fillInStackTrace(): Throwable {
        return this
    }
}
