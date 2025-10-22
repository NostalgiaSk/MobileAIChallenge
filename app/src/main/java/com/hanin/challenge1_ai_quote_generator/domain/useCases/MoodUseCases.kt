package com.hanin.challenge1_ai_quote_generator.domain.useCases

import com.hanin.challenge1_ai_quote_generator.data.local.MoodDataStore
import com.hanin.challenge1_ai_quote_generator.domain.model.Mood
import kotlinx.coroutines.flow.Flow

class SaveMoodUseCase(private val moodStore: MoodDataStore) {
    suspend operator fun invoke(mood: Mood) = moodStore.saveMood(mood)
}

class GetMoodUseCase(private val moodStore: MoodDataStore) {
    operator fun invoke(): Flow<Mood> = moodStore.getMood()
}
