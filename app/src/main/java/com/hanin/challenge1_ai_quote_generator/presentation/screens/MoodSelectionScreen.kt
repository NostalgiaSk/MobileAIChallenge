package com.hanin.challenge1_ai_quote_generator.presentation.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanin.challenge1_ai_quote_generator.components.MoodSelectorGrid
import com.hanin.challenge1_ai_quote_generator.domain.model.Mood


// --- Fake ViewModel for Preview ---
class PreviewMoodViewModel {
    var selectedMood by mutableStateOf(Mood.NEUTRAL)
    fun updateMood(mood: Mood) { selectedMood = mood }
    fun saveMood() {}
}

// --- MoodScreen ---
@Composable
fun MoodScreen(viewModel: PreviewMoodViewModel, onContinue: () -> Unit) {
    val currentMood = viewModel.selectedMood

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("How do you feel today?", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(24.dp))

        MoodSelectorGrid(
            selectedMood = currentMood,
            onMoodSelected = { viewModel.updateMood(it) }
        )

        Spacer(Modifier.height(32.dp))
        Button(onClick = {
            viewModel.saveMood()
            onContinue()
        }) {
            Text("Continue")
        }
    }
}

// --- Preview ---
@Preview(showBackground = true)
@Composable
fun MoodScreenPreview() {
    val fakeViewModel = remember { PreviewMoodViewModel() }
    MoodScreen(viewModel = fakeViewModel, onContinue = {})
}
