package com.hanin.challenge1_ai_quote_generator.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanin.challenge1_ai_quote_generator.domain.model.Mood
import com.hanin.challenge1_ai_quote_generator.domain.useCases.GetMoodUseCase
import com.hanin.challenge1_ai_quote_generator.domain.useCases.SaveMoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class MoodViewModel @Inject constructor(
    private val saveMoodUseCase: SaveMoodUseCase,
    private val getMoodUseCase: GetMoodUseCase
) : ViewModel() {

    var selectedMood by mutableStateOf(Mood.NEUTRAL)
        private set

    fun updateMood(mood: Mood) {
        selectedMood = mood
    }

    fun saveMood() {
        viewModelScope.launch {
            saveMoodUseCase(selectedMood)
        }
    }

    init {
        viewModelScope.launch {
            getMoodUseCase().collect {
                selectedMood = it
            }
        }
    }
}
