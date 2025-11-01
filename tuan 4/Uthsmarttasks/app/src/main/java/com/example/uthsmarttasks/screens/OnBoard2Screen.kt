package com.example.uthsmarttasks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

class OnBoard2Screen(navController: NavController) : BaseOnBoardScreen(navController) {

    override val imageRes = R.drawable.onboard_2
    override val title = "Increase Work Effectiveness"
    override val description =
        "Time management and determining important tasks help improve your work performance and efficiency."
    override val currentPage = 1
    override val totalPages = 3

    override fun onNext() {
        navController.navigate("onboard3")
    }

    override fun onBack() {
        navController.popBackStack() // Quay lại OnBoard1
    }

    override fun onSkip() {
        navController.navigate("splash") {
            popUpTo("onboard2") { inclusive = true }
        }
    }

    @Composable
    fun Show() {
        Content()
    }
}
