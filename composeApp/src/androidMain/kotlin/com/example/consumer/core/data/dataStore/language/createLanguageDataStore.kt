package com.example.consumer.core.data.dataStore.language

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.consumer.core.data.dataStore.DATA_STORE_FILE_NAME
import com.example.consumer.core.data.dataStore.createDataStore


fun createLanguageDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve("language_" + DATA_STORE_FILE_NAME).absolutePath
    }
}