package com.example.consumer.core.data.useCases.language

import com.example.consumer.core.data.AppLang
import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.core.data.toAppLang
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSelectedLanguageUseCase(private val languageDataStore: LanguageDataStore) {
    operator fun invoke(): Flow<AppLang> =
        languageDataStore.selectedLanguageFlow.map { it.toAppLang() }
}

