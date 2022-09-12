package com.example.kimiljeongdomain.error

interface ErrorProperty {
    fun status(): Int
    fun code(): String
    fun message(): String
}