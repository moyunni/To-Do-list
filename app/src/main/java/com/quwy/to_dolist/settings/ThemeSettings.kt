package com.quwy.to_dolist.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeSettings(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        val THEME_KEY = stringPreferencesKey("theme")
        val DYNAMIC_COLOR_KEY = booleanPreferencesKey("dynamic_color")
    }

    val theme: Flow<String> = dataStore.data.map {
        it[THEME_KEY] ?: "system"
    }

    val dynamicColor: Flow<Boolean> = dataStore.data.map {
        it[DYNAMIC_COLOR_KEY] ?: false
    }

    suspend fun setTheme(theme: String) {
        dataStore.edit {
            it[THEME_KEY] = theme
        }
    }

    suspend fun setDynamicColor(enabled: Boolean) {
        dataStore.edit {
            it[DYNAMIC_COLOR_KEY] = enabled
        }
    }
}