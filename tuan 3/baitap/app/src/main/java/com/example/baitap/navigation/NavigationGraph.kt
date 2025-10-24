package com.example.baitap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baitap.ui.theme.screens.ComponentListScreen
import com.example.baitap.ui.theme.screens.PasswordFieldScreen
import com.example.baitap.ui.theme.screens.WelcomeScreen
import com.example.baitap.ui.theme.screens.ImageScreen
import com.example.baitap.ui.theme.screens.RowLayoutScreen
import com.example.baitap.ui.theme.screens.ColumnLayoutScreen
import com.example.baitap.ui.theme.screens.TextFieldScreen
import com.example.baitap.ui.theme.screens.TextDetailScreen
import com.example.baitap.ui.theme.screens.CheckboxScreen
import com.example.baitap.ui.theme.screens.LazyColumnScreen





@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("list") { ComponentListScreen(navController) }
        composable("password") { PasswordFieldScreen() }
        composable("image") { ImageScreen() }
        composable("row") { RowLayoutScreen(navController) }
        composable("column") { ColumnLayoutScreen(navController) }
        composable("textfield") { TextFieldScreen() }
        composable("textdetail") { TextDetailScreen() }
        composable("checkbox") { CheckboxScreen(navController) }
        composable("lazycolumn") { LazyColumnScreen(navController) }



    }
}
