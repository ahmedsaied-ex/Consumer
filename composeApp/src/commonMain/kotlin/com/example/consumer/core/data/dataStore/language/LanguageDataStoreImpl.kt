package com.example.consumer.core.data.dataStore.language

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.text.get

class LanguageDataStoreImpl(
    private val dataStore: DataStore<Preferences>
) : LanguageDataStore {

    override val selectedLanguageFlow: Flow<String?> =
        dataStore.data.map { preferences ->
            preferences[LanguagePreferences.SELECTED_LANGUAGE]
        }

    override val isLanguageSelectedFlow: Flow<Boolean> =
        dataStore.data.map { preferences ->
            preferences[LanguagePreferences.IS_LANGUAGE_SELECTED] ?: false
        }

    override suspend fun saveLanguage(languageCode: String) {
        dataStore.edit { preferences ->
            preferences[LanguagePreferences.SELECTED_LANGUAGE] = languageCode
        }
    }

    override suspend fun markLanguageAsSelected() {
        dataStore.edit { preferences ->
            preferences[LanguagePreferences.IS_LANGUAGE_SELECTED] = true
        }
    }

    override suspend fun saveLanguageAndMarkSelected(languageCode: String) {
        dataStore.edit { preferences ->
            preferences[LanguagePreferences.SELECTED_LANGUAGE] = languageCode
            preferences[LanguagePreferences.IS_LANGUAGE_SELECTED] = true
        }
    }
}
