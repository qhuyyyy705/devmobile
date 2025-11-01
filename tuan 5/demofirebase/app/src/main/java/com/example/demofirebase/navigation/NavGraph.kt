package com.example.demofirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demofirebase.screens.LoginScreen
import com.example.demofirebase.screens.ProfileScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginScreen(navController = navController).Content()
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController).Content()
        }
    }
}