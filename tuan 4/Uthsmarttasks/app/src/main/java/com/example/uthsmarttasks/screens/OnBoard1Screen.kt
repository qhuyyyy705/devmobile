package com.example.uthsmarttasks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

class OnBoard1Screen(navController: NavController) : BaseOnBoardScreen(navController) {

    override val imageRes = R.drawable.onboard_1
    override val title = "Easy Time Management"
    override val description =
        "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first."
    override val currentPage = 0
    override val totalPages = 3

    override fun onNext() {
        navController.navigate("onboard2")
    }

    override fun onBack() {
        // Không có back cho trang đầu
    }

    override fun onSkip() {
        navController.navigate("splash") {
            popUpTo("onboard1") { inclusive = true }
        }
    }

    @Composable
    fun Show() {
        Content()
    }
}
