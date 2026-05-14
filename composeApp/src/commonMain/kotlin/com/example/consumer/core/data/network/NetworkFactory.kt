package com.example.consumer.core.data.network

import com.example.consumer.core.config.AppConfig
import com.example.consumer.core.data.logging.formatIfJson
import com.example.consumer.core.data.logging.logLong
import com.example.consumer.core.domain.utils.CostumeLogger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkFactory(
    private val json: Json,
    private val auctionLogger: CostumeLogger,
    private val appConfig: AppConfig,
    private val onForceLogout: () -> Unit,
) {
    private val clientCache = mutableMapOf<String, HttpClient>()

    fun getClient(
        baseUrl: String = appConfig.apiBaseUrl,
        enableLogging: Boolean = appConfig.isDebugMode,
    ): HttpClient =
        clientCache.getOrPut(baseUrl) {
            createClient(baseUrl, enableLogging)
        }
    fun invalidateAuthState() {
        clientCache.values.forEach { it.close() }
        clientCache.clear()
    }

    private fun createClient(
        baseUrl: String,
        enableLogging: Boolean,
    ): HttpClient =
        HttpClient {

            // Response validation
            HttpResponseValidator {
                validateResponse { response ->
                    // Force logout on 401 Unauthorized
                    if (response.status.value == 401) {
                        onForceLogout()
                    }
                }
            }

            // Install Language Header Plugin
//            install(LanguageHeaderPlugin) {
//                languageDataStore = this@NetworkFactory.languageDataStore
//            }

            // Base configuration
            defaultRequest {
                url(baseUrl)

                // Static headers from ApiConfig
                ApiConfig.getHeaders().forEach { (key, value) ->
                    header(key, value)
                }
            }

            // JSON serialization
            install(ContentNegotiation) {
                json(this@NetworkFactory.json)
            }

            // Timeout configuration
            install(HttpTimeout) {
                requestTimeoutMillis = appConfig.networkTimeoutMs
                connectTimeoutMillis = appConfig.networkTimeoutMs
            }

            // Auth
//            install(Auth) {
//                bearer {
//                    loadTokens {
//                        authTokenProvider.getAccessToken()?.let {
//                            BearerTokens(it, "")
//                        }
//                    }
//                    refreshTokens {
//                        authTokenProvider.getAccessToken()?.let {
//                            BearerTokens(it, "")
//                        }
//                    }
//                }
//            }

            // Logging
            if (enableLogging) {
                install(Logging) {
                    logger = object : Logger {
                        private var collectingBody = false
                        private val bodyBuffer = StringBuilder()

                        override fun log(message: String) {
                            when {
                                message.trim() == "BODY START" -> {
                                    collectingBody = true
                                    bodyBuffer.clear()
                                }

                                message.trim() == "BODY END" -> {
                                    collectingBody = false
                                    val rawBody = bodyBuffer.toString().trim()
                                    if (rawBody.isNotEmpty()) {
                                        logLong(
                                            tag = "Ktor-Body",
                                            message = formatIfJson(rawBody),
                                            logger = auctionLogger
                                        )
                                    }
                                }

                                collectingBody -> {
                                    bodyBuffer.appendLine(message)
                                }

                                else -> {
                                    auctionLogger.info("[Ktor]"," $message")
                                }
                            }
                        }
                    }
                    level = LogLevel.ALL
                }
            }

            // Retry policy - Only retry temporary server errors, not network issues
            install(HttpRequestRetry) {
                maxRetries = 0
            }
        }

    fun cleanup() {
        clientCache.values.forEach { it.close() }
        clientCache.clear()
    }
}
