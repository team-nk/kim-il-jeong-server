package com.example.kimiljeongdomain.user.spi

interface JwtTokenGeneratePort {
    fun generateAccessToken(accountId: String): String
    fun generateRefreshToken(accountID: String): String
}