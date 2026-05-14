package com.example.consumer.core.config

interface AppConfig {
    val environment: Environment
    val appName: String
    val apiBaseUrl: String
    val apiKey: String
    val isDebugMode: Boolean
    val networkTimeoutMs: Long
    val cacheExpirationMinutes: Int
    val maxRetryAttempts: Int
    val enableAnalytics: Boolean
    val enableCrashReporting: Boolean
    val logLevel: LogLevel
}
enum class Environment {
    DEVELOPMENT,
    STAGING,
    PRODUCTION,
}
enum class LogLevel {
    VERBOSE,
    DEBUG,
    INFO,
    WARN,
    ERROR,
    NONE,
}

data class DefaultAppConfig(
    override val environment:Environment,
    override val appName: String,
    override val apiBaseUrl: String,
    override val apiKey: String,
    override val isDebugMode: Boolean,
    override val networkTimeoutMs: Long,
    override val cacheExpirationMinutes: Int,
    override val maxRetryAttempts: Int,
    override val enableAnalytics: Boolean,
    override val enableCrashReporting: Boolean,
    override val logLevel: LogLevel,
) :AppConfig

expect object BuildConfig {
    val environment: String
    val isDebug: Boolean
    val apiBaseUrl: String
    val apiKey: String
    val enableAnalytics: Boolean
    val enableCrashReporting: Boolean
}


/**
 * Factory for creating environment-specific configurations
 * Follows Factory Pattern and Single Responsibility Principle
 * Separates configuration creation logic from configuration data
 */
object AppConfigFactory {
    /**
     * Creates AppConfig from BuildConfig
     * Follows Open/Closed Principle - easy to extend with new environments
     */
    fun create(): AppConfig {
        val environment = parseEnvironment(BuildConfig.environment)
        return createForEnvironment(environment)
    }

    /**
     * Creates configuration for specific environment
     * Allows dependency injection and testing
     */
    fun createForEnvironment(environment: Environment): AppConfig =
        when (environment) {
            Environment.DEVELOPMENT -> createDevelopmentConfig()
            Environment.STAGING -> createStagingConfig()
            Environment.PRODUCTION -> createProductionConfig()
        }

    private fun parseEnvironment(envString: String): Environment =
        when (envString.lowercase()) {
            "development", "dev" -> Environment.DEVELOPMENT
            "staging", "stage" -> Environment.STAGING
            "production", "prod" -> Environment.PRODUCTION
            else -> Environment.DEVELOPMENT // Safe default
        }

    private fun createDevelopmentConfig(): AppConfig =
        DefaultAppConfig(
            environment = Environment.DEVELOPMENT,
            appName = "AuctionEX Dev",
            apiBaseUrl = BuildConfig.apiBaseUrl,
            apiKey = BuildConfig.apiKey,
            isDebugMode = true,
            networkTimeoutMs = 30_000L,
            cacheExpirationMinutes = 5,
            maxRetryAttempts = 3,
            enableAnalytics = false,
            enableCrashReporting = false,
            logLevel = LogLevel.DEBUG,
        )

    private fun createStagingConfig(): AppConfig =
        DefaultAppConfig(
            environment = Environment.STAGING,
            appName = "AuctionEX Staging",
            apiBaseUrl = BuildConfig.apiBaseUrl,
            apiKey = BuildConfig.apiKey,
            isDebugMode = false,
            networkTimeoutMs = 20_000L,
            cacheExpirationMinutes = 5,
            maxRetryAttempts = 3,
            enableAnalytics = true,
            enableCrashReporting = true,
            logLevel = LogLevel.INFO,
        )

    private fun createProductionConfig(): AppConfig =
        DefaultAppConfig(
            environment = Environment.PRODUCTION,
            appName = "AuctionEX",
            apiBaseUrl = BuildConfig.apiBaseUrl,
            apiKey = BuildConfig.apiKey,
            isDebugMode = false,
            networkTimeoutMs = 15_000L, // Stricter timeout in production
            cacheExpirationMinutes = 5,
            maxRetryAttempts = 3,
            enableAnalytics = true,
            enableCrashReporting = true,
            logLevel = LogLevel.ERROR,
        )
}
