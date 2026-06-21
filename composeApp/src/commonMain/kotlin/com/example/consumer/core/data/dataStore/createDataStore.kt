package com.example.consumer.core.data.dataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

internal const val DATA_STORE_FILE_NAME = "prefs.preferences_pb"

fun createDataStore(
    producePath: () -> String
): DataStore<Preferences> =
    PreferenceDataStoreFactory.createWithPath {
        producePath().toPath()
    }
