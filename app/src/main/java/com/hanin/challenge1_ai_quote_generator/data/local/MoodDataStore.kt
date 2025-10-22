package com.hanin.challenge1_ai_quote_generator.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.hanin.challenge1_ai_quote_generator.domain.model.Mood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MoodDataStore(private val dataStore: DataStore<Preferences>) {

    companion object {
        val MOOD_KEY = intPreferencesKey("user_mood")
    }

    suspend fun saveMood(mood: Mood) {
        dataStore.edit { prefs ->
            prefs[MOOD_KEY] = mood.ordinal
        }
    }

    fun getMood(): Flow<Mood> = dataStore.data.map { prefs ->
        val ordinal = prefs[MOOD_KEY] ?: Mood.NEUTRAL.ordinal
        Mood.values().getOrElse(ordinal) { Mood.NEUTRAL }
    }
}
