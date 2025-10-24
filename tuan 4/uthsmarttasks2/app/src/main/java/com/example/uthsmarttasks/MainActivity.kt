package com.example.uthsmarttasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uthsmarttasks.screens.*
import com.example.uthsmarttasks.ui.theme.UTHSmartTasksTheme
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTHSmartTasksTheme {
                SmartTasksApp()
            }
        }
    }
}

@Composable
fun SmartTasksApp() {
    val navController = rememberNavController()
    val sharedViewModel = remember { SharedViewModel() } // ✅ giữ dữ liệu chung

    NavHost(
        navController = navController,
        startDestination = "forgot"
    ) {
        composable("forgot") {
            ForgotPasswordScreen(
                viewModel = sharedViewModel,
                onNext = { navController.navigate("verify") }
            )
        }
        composable("verify") {
            VerifyCodeScreen(
                viewModel = sharedViewModel,
                onBack = { navController.popBackStack() },
                onNext = { navController.navigate("reset") }
            )
        }
        composable("reset") {
            ResetPasswordScreen(
                viewModel = sharedViewModel,
                onBack = { navController.popBackStack() },
                onNext = { navController.navigate("confirm") }
            )
        }
        composable("confirm") {
            ConfirmScreen(
                viewModel = sharedViewModel,
                onBack = { navController.popBackStack() }, // ✅ Fix lỗi
                onSubmit = {
                    navController.navigate("forgot") {
                        popUpTo("forgot") { inclusive = true }
                    }
                }
            )
        }
    }
}
