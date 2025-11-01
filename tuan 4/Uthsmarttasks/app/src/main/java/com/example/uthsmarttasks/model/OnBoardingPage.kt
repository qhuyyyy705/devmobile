package com.example.uthsmarttasks.model

import com.example.uthsmarttasks.R

sealed class OnBoardingPage(
    val imageRes: Int,
    val title: String,
    val description: String
) {
    object Onboard1 : OnBoardingPage(
        R.drawable.onboard_1,
        "Easy Time Management",
        "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first."
    )

    object Onboard2 : OnBoardingPage(
        R.drawable.onboard_2,
        "Increase Work Effectiveness",
        "Time management and determining important tasks help improve your work performance and efficiency."
    )

    object Onboard3 : OnBoardingPage(
        R.drawable.onboard_3,
        "Reminder Notification",
        "This app provides reminders so you don't forget to complete your assignments on time."
    )
}
