package com.example.consumer.core.data.useCases.language

import com.example.consumer.core.data.dataStore.language.LanguageDataStore

class SaveLanguageOnlyUseCase(
    private val languageDataStore: LanguageDataStore
) {
    suspend operator fun invoke(languageCode: String) {
        languageDataStore.saveLanguage(languageCode)
    }
}