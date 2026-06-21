package com.example.consumer.features.languageSelection.data

import com.example.consumer.core.data.dataStore.language.LanguageDataStore

class SaveLanguageOnlyUseCase(
    private val languageDataStore: LanguageDataStore
) {
    suspend operator fun invoke(languageCode: String) {
        languageDataStore.saveLanguage(languageCode)
    }
}
