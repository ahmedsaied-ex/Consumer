package com.example.consumer.features.splashScreen.data

import com.example.consumer.core.data.dataStore.language.LanguageDataStore
import com.example.consumer.core.domain.dataStorage.SessionStorage
import com.example.consumer.features.splashScreen.domain.model.SplashDestination
import com.example.consumer.features.splashScreen.domain.repository.SplashRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine


class SplashRepositoryImpl(
    private val sessionStorage: SessionStorage,
    private val languageDataStore: LanguageDataStore
) : SplashRepository {
    override fun getSplashDestination(): Flow<SplashDestination> {
        return combine(
            languageDataStore.isLanguageSelectedFlow,
            languageDataStore.selectedLanguageFlow,
            sessionStorage.observeAuthInfo()
        ) { isLanguageSelected, selectedLanguageCode, authData ->
            println("DEBUG SplashRepository: isLanguageSelected=$isLanguageSelected, selectedLanguageCode=$selectedLanguageCode, authData=${if (authData != null) "LOGGED_IN" else "NULL"}")
            println("DEBUG SplashRepository: authData details: $authData")

            // Extra validation: if marked as selected, verify a language code exists
            val hasValidLanguage = isLanguageSelected && !selectedLanguageCode.isNullOrEmpty()

            val destination = if (!hasValidLanguage) {
                SplashDestination.LanguageSelection
            } else if (authData != null) {
                SplashDestination.Home
            } else {
                SplashDestination.Auth
            }

            println("DEBUG SplashRepository: Final destination = $destination")
            destination
        }
    }
}
