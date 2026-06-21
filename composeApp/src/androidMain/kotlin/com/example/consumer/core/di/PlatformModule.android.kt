package com.example.consumer.core.di

import com.example.consumer.core.config.AppConfig
import com.example.consumer.core.data.dataStore.createDataStore
import com.example.consumer.core.domain.AndroidAnalyticsLogger
import com.example.consumer.core.domain.AndroidLogger
import com.example.consumer.core.domain.model.AnalyticsLogger
import com.example.consumer.core.domain.model.Logger
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule =
    module {
        // Core
        single<HttpClientEngine> { Android.create() }

        // Platform-specific logging
        single<Logger> { AndroidLogger(get<AppConfig>()) }
        single<AnalyticsLogger> { AndroidAnalyticsLogger(get<AppConfig>()) }
        single { createDataStore(androidContext()) }

    }
