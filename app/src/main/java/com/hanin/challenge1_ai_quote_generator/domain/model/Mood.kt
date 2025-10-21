package com.hanin.challenge1_ai_quote_generator.domain.model

enum class Mood(val level: Int, val label: String) {
    VERY_SAD(1, "Very Sad 😢"),
    SAD(2, "Sad 🙁"),
    NEUTRAL(3, "Neutral 😐"),
    HAPPY(4, "Happy 🙂"),
    VERY_HAPPY(5, "Very Happy 😄");

    companion object {
        fun fromLevel(level: Int): Mood = values().firstOrNull { it.level == level } ?: NEUTRAL
    }
}
