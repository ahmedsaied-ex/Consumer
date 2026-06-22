package com.example.consumer.core.domain.auth

interface AuthTokenProvider {
    suspend fun getAccessToken(): String?
    suspend fun clear()
}
