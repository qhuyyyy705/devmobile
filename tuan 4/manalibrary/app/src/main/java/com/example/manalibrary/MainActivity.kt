package com.example.manalibrary   // 👉 đổi theo tên package của bạn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.manalibrary.model.Book
import com.example.manalibrary.model.Student
import com.example.manalibrary.screens.DSSachScreen
import com.example.manalibrary.screens.QuanLyScreen
import com.example.manalibrary.screens.SinhVienScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryApp()
        }
    }
}

@Composable
fun LibraryApp() {
    val navController = rememberNavController()

    val books = remember {
        mutableStateListOf(Book("Sách 01"), Book("Sách 02"), Book("Sách 03"))
    }

    val students = remember {
        mutableStateListOf(
            Student("Nguyen Van A", mutableListOf("Sách 01", "Sách 02")),
            Student("Nguyen Thi B", mutableListOf("Sách 01")),
            Student("Nguyen Van C", mutableListOf())
        )
    }

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "quanly",
            modifier = androidx.compose.ui.Modifier.padding(padding)
        ) {
            composable("quanly") { QuanLyScreen(students, books) }
            composable("dssach") { DSSachScreen(books) }
            composable("sinhvien") { SinhVienScreen(students) }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf("quanly", "dssach", "sinhvien")
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(screen) },
                label = { Text(screen.replaceFirstChar { it.uppercase() }) },
                icon = {
                    Icon(
                        androidx.compose.material.icons.Icons.Default.Home,
                        contentDescription = null
                    )
                }
            )
        }
    }
}
