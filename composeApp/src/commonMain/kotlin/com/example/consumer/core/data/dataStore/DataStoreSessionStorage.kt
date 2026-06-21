package com.example.consumer.core.data.dataStore


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.consumer.core.domain.dataStorage.Data
import com.example.consumer.core.domain.dataStorage.SessionStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

class DataStoreSessionStorage(
    private val dataStore: DataStore<Preferences>
) : SessionStorage {

    private val authInfoKey = stringPreferencesKey("KEY_AUTH_INFO")

    private val json = Json {
        ignoreUnknownKeys = true
    }

    override fun observeAuthInfo(): Flow<Data?> {
        return dataStore.data.map { preferences ->
            preferences[authInfoKey]?.let {
                json.decodeFromString(Data.serializer(), it)
            }
        }
    }

    override suspend fun set(info: Data?) {
        dataStore.edit { prefs ->
            if (info == null) {
                prefs.remove(authInfoKey)
                println("USER_DEBUG in set fun if info = null : Auth ID: $info")

            } else {
                prefs[authInfoKey] =
                    json.encodeToString(Data.serializer(), info)

                println("USER_DEBUG in set fun else : Auth ID: $info")
            }
        }
    }


}
