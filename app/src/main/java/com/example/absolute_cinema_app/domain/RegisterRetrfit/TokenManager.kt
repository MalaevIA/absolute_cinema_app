package com.example.absolute_cinema_app.domain.RegisterRetrfit

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// Расширение для доступа к DataStore
private val Context.dataStore by preferencesDataStore(name = "auth")

object TokenManager {
    private val TOKEN_KEY = stringPreferencesKey("token")

    suspend fun saveToken(context: Context, token: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }

    suspend fun getToken(context: Context): String? {
        return context.dataStore.data
            .map { preferences -> preferences[TOKEN_KEY] }
            .first()
    }

    suspend fun clearToken(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN_KEY)
        }
    }
}