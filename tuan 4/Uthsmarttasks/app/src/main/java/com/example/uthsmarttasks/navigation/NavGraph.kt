package com.example.uthsmarttasks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uthsmarttasks.screens.*

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route

    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.OnBoard1.route) {
            val screen = OnBoard1Screen(navController)
            screen.Show()
        }

        composable(Screen.OnBoard2.route) {
            val screen = OnBoard2Screen(navController)
            screen.Show()
        }
        composable(Screen.OnBoard3.route) {
            val screen = OnBoard3Screen(navController)
            screen.Show()
        }
    }
}
