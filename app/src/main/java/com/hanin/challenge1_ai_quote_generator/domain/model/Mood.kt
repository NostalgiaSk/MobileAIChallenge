package com.hanin.challenge1_ai_quote_generator.domain.model

import com.hanin.challenge1_ai_quote_generator.R


enum class Mood(val label: String, val lottieRes: Int) {
    VERY_SAD("Very Sad 😢", R.raw.very_sad),
    SAD("Sad 🙁", R.raw.sad),
    NEUTRAL("Neutral 😐", R.raw.neutral),
    HAPPY("Happy 🙂", R.raw.happy),
    VERY_HAPPY("Very Happy 😄", R.raw.very_happy);

    companion object {
        fun fromLevel(level: Int): Mood {
            val index = level.coerceIn(values().indices)
            return values()[index]
        }
    }
}
