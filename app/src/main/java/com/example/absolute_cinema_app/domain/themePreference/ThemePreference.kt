package com.example.absolute_cinema_app.domain.themePreference

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class ThemePreference(private val context: Context) {
    companion object {
        val DARK_THEME = booleanPreferencesKey("dark_theme")
    }

    val themeFlow: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[DARK_THEME] ?: false }

    suspend fun saveTheme(isDark: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[DARK_THEME] = isDark
        }
    }
}
