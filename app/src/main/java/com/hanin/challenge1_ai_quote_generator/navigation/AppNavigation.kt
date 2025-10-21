package com.hanin.challenge1_ai_quote_generator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hanin.challenge1_ai_quote_generator.presentation.screens.ChatScreen
import com.hanin.challenge1_ai_quote_generator.presentation.screens.MoodSelectionScreen
import com.hanin.challenge1_ai_quote_generator.presentation.screens.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = AppScreens.SplashScreen.name ){

        composable(AppScreens.SplashScreen.name ) {
            SplashScreen()
        }

        composable(AppScreens.ChatScreen.name){
            ChatScreen()
        }

        composable(AppScreens.MoodSelectionScreen.name){
            MoodSelectionScreen()
        }


    }

}