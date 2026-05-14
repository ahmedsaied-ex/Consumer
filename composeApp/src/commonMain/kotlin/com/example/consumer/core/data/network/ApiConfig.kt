package com.example.consumer.core.data.network

import com.example.consumer.core.config.AppConfig
import com.example.consumer.core.config.Environment


/**
 * API Configuration
 * Centralized configuration for all API endpoints
 */
object ApiConfig {

    private lateinit var appConfig: AppConfig

    fun init(config: AppConfig) {
        appConfig = config
    }

    val baseUrl: String
        get() = appConfig.apiBaseUrl

    val apiKey: String
        get() = appConfig.apiKey

    val environment: Environment
        get() = appConfig.environment

    // Flat config — no nested object issue
    val timeoutSeconds: Long
        get() = appConfig.networkTimeoutMs / 1000
    val retryCount: Int
        get() = appConfig.maxRetryAttempts

    const val CACHE_SIZE_MB = 10L

    fun getHeaders(): Map<String, String> =
        buildMap {
            put("Accept", "application/json")
            put("Content-Type", "application/json")
        }
}