package com.hanin.challenge1_ai_quote_generator.navigation

enum class AppScreens {
    SplashScreen,
    ChatScreen,
    MoodSelectionScreen;



    companion object{
        fun fromRoute(route: String?):AppScreens = when(route?.substringBefore("/"))
        {
            SplashScreen.name -> SplashScreen
            ChatScreen.name -> ChatScreen
            MoodSelectionScreen.name -> MoodSelectionScreen

            null -> ChatScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}