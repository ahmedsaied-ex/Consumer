package com.example.consumer.core.di

import com.example.consumer.core.config.AppConfig
import com.example.consumer.core.config.AppConfigFactory
import com.example.consumer.core.data.dataStore.DataStoreSessionStorage
import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.core.data.dataStore.language.LanguageDataStoreImpl
import com.example.consumer.core.data.logging.KermitLogger
import com.example.consumer.core.data.network.DataStoreAuthTokenProvider
import com.example.consumer.core.data.network.NetworkFactory
import com.example.consumer.core.domain.dataStorage.SessionStorage
import com.example.consumer.core.domain.model.DefaultDispatcherProvider
import com.example.consumer.core.domain.model.DispatcherProvider
import com.example.consumer.core.domain.utils.CostumeLogger
import com.example.consumer.core.data.useCases.language.GetSelectedLanguageUseCase
import com.example.consumer.core.data.useCases.language.SaveLanguageOnlyUseCase
import com.example.consumer.core.domain.auth.AuthTokenProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule =
    module {
        single<CoroutineScope> {
            CoroutineScope(SupervisorJob() + Dispatchers.Main)
        }
        single<AppConfig> { AppConfigFactory.create() }
        single<DispatcherProvider> { DefaultDispatcherProvider() }
        single<Json> {
            Json {
                ignoreUnknownKeys = true
                encodeDefaults = false
                isLenient = true
                explicitNulls = false
                prettyPrint = true
            }
        }
        single<CostumeLogger> { KermitLogger }
        singleOf(::NetworkFactory)

        // Language
        single<SessionStorage> {
            DataStoreSessionStorage(get())
        }
        singleOf(::LanguageDataStoreImpl) bind LanguageDataStore::class
        singleOf(::GetSelectedLanguageUseCase)
        singleOf(::SaveLanguageOnlyUseCase)


        // Network
        singleOf(::DataStoreAuthTokenProvider) bind AuthTokenProvider::class
    }