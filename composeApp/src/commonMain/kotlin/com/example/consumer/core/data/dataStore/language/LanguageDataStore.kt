package com.example.consumer.core.data.dataStore.language
import kotlinx.coroutines.flow.Flow

interface LanguageDataStore {
    val selectedLanguageFlow: Flow<String?>
    val isLanguageSelectedFlow: Flow<Boolean>
    suspend fun saveLanguage(languageCode: String)
    suspend fun markLanguageAsSelected()
    suspend fun saveLanguageAndMarkSelected(languageCode: String)
}
