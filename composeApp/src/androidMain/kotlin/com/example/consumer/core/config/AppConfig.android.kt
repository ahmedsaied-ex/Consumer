package com.example.consumer.core.config


import com.example.consumer.BuildConfig as AndroidBuildConfig  // ✅ this should work

actual object BuildConfig {
    actual val environment: String = AndroidBuildConfig.ENVIRONMENT
    actual val isDebug: Boolean = AndroidBuildConfig.IS_DEBUG
    actual val apiBaseUrl: String = AndroidBuildConfig.API_BASE_URL
    actual val apiKey: String = AndroidBuildConfig.API_KEY
    actual val enableAnalytics: Boolean = AndroidBuildConfig.ENABLE_ANALYTICS
    actual val enableCrashReporting: Boolean = AndroidBuildConfig.ENABLE_CRASH_REPORTING
}