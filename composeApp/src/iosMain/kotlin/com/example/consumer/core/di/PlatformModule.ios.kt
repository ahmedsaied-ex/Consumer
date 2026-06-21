package com.example.consumer.core.di

import com.example.consumer.core.config.AppConfig
import com.example.consumer.core.data.dataSrore.createDataStore
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.IOSAnalyticsLogger
import com.example.consumer.core.domain.model.IOSLogger
import com.example.consumer.core.domain.model.Logger
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual val platformModule =
    module {
        // HTTP Client Engine for Ktor
        single<HttpClientEngine> { Darwin.create() }

        // Platform-specific logging
        single<Logger> { IOSLogger(get<AppConfig>()) }
        single<AnalyticsLogger> { IOSAnalyticsLogger(get<AppConfig>()) }

        single { createDataStore() }

    }
