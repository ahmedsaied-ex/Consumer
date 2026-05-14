package com.example.consumer.core.config

actual object BuildConfig {
    actual val environment: String = "development"
    actual val isDebug: Boolean = true
    actual val apiBaseUrl: String = "https://api.auctionex.com/v1"
    actual val apiKey: String = ""
    actual val enableAnalytics: Boolean = false
    actual val enableCrashReporting: Boolean = false
}
