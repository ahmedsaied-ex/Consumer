package com.example.consumer.features.languageSelection.domain

interface ConfirmLanguageSelectionUseCase {
    suspend operator fun invoke()
    suspend fun confirmWithLanguage(languageCode: String)
}
