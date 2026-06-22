package com.example.consumer.core.data.useCases.language

import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.features.languageSelection.domain.ConfirmLanguageSelectionUseCase

class ConfirmLanguageSelectionUseCaseImpl(
    private val languageDataStore: LanguageDataStore
) : ConfirmLanguageSelectionUseCase {
    override suspend operator fun invoke() {
        languageDataStore.markLanguageAsSelected()
    }

    override suspend fun confirmWithLanguage(languageCode: String) {
        // Atomic operation: save language and mark as selected together
        languageDataStore.saveLanguageAndMarkSelected(languageCode)
    }
}
