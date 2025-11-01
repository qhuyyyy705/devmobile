package com.example.uthsmarttasks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uthsmarttasks.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Sau 2 giây chuyển sang OnBoard1
    LaunchedEffect(Unit) {
        delay(6000)
        navController.navigate(Screen.OnBoard1.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    val UthDarkGreen = Color(0xFF007A7C)
    val PrimaryBlue = Color(0xFF1976D2)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo chữ UTH
            Text(
                text = "UTH",
                color = UthDarkGreen,
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Dòng phụ “UNIVERSITY OF TRANSPORT HO CHI MINH CITY”
            Text(
                text = "UNIVERSITY OF TRANSPORT\nHO CHI MINH CITY",
                color = Color(0xFFB71C1C),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                lineHeight = 14.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Tên app
            Text(
                text = "UTH SmartTasks",
                color = PrimaryBlue,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
