package com.example.consumer.core.data.network

import com.example.consumer.core.domain.auth.AuthTokenProvider
import com.example.consumer.core.domain.dataStorage.SessionStorage
import kotlinx.coroutines.flow.firstOrNull

class DataStoreAuthTokenProvider(
    private val sessionStorage: SessionStorage
) : AuthTokenProvider {

    override suspend fun getAccessToken(): String? {
        val token = sessionStorage
            .observeAuthInfo()
            .firstOrNull()
            ?.token

        println("USER_DEBUG: AuthTokenProvider - getAccessToken: ${if (token != null) "FOUND" else "NULL"} -> $token")
        return token
    }

    override suspend fun clear() {
        println("USER_DEBUG: AuthTokenProvider - clear() called")
        sessionStorage.set(null)
    }
}
