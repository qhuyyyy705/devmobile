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
        startDestination = "splash"
    ) {
        composable("splash") { SplashScreen(navController) }
        composable("onboard1") { OnBoard1Screen(navController) }
        composable("onboard2") { OnBoard2Screen(navController) }
        composable("onboard3") { OnBoard3Screen(navController) }

    }
}

