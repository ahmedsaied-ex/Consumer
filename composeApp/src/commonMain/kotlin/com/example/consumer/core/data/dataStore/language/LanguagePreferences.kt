package com.example.consumer.core.data.dataStore.language

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey


object LanguagePreferences {
    val SELECTED_LANGUAGE = stringPreferencesKey("selected_language")
    val IS_LANGUAGE_SELECTED = booleanPreferencesKey("is_language_selected")
}
