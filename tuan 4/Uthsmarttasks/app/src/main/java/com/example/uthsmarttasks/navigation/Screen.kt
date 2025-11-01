package com.example.uthsmarttasks.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object OnBoard1 : Screen("onboard1")
    object OnBoard2 : Screen("onboard2")
    object OnBoard3 : Screen("onboard3")
}
