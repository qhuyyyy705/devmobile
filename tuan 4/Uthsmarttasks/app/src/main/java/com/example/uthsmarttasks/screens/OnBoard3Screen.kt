package com.example.uthsmarttasks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

class OnBoard3Screen(navController: NavController) : BaseOnBoardScreen(navController) {

    override val imageRes = R.drawable.onboard_3
    override val title = "Reminder Notification"
    override val description =
        "This app provides reminders so you don't forget to complete your assignments on time."
    override val currentPage = 2
    override val totalPages = 3

    override fun onNext() {
        navController.navigate("splash") {
            popUpTo("onboard3") { inclusive = true }
        }
    }

    override fun onBack() {
        navController.popBackStack()
    }

    override fun onSkip() {
        navController.navigate("splash") {
            popUpTo("onboard3") { inclusive = true }
        }
    }

    @Composable
    fun Show() {
        Content()
    }
}
