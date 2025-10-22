package com.hanin.challenge1_ai_quote_generator.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.hanin.challenge1_ai_quote_generator.data.local.MoodDataStore
import com.hanin.challenge1_ai_quote_generator.domain.useCases.GetMoodUseCase
import com.hanin.challenge1_ai_quote_generator.domain.useCases.SaveMoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoodModule {

    @Provides
    @Singleton
    fun provideMoodDataStore(@ApplicationContext context: Context): MoodDataStore {
        val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile("mood_prefs") }
        )
        return MoodDataStore(dataStore)
    }

    @Provides
    fun provideSaveMoodUseCase(store: MoodDataStore) = SaveMoodUseCase(store)

    @Provides
    fun provideGetMoodUseCase(store: MoodDataStore) = GetMoodUseCase(store)
}
