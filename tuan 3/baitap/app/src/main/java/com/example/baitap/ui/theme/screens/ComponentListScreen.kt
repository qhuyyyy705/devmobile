package com.example.baitap.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ComponentListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🟦 Tiêu đề
        Text(
            text = "UI Components List",
            color = Color(0xFF2196F3),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🧩 Nhóm Display
        SectionTitle("Display")
        ButtonItem("Text", "Displays text") { navController.navigate("textdetail") }
        ButtonItem("Image", "Displays an image") { navController.navigate("image") }

        // 🧠 Nhóm Input
        SectionTitle("Input")
        ButtonItem("TextField", "Input field for text") { navController.navigate("textfield") }
        ButtonItem("PasswordField", "Input field for passwords") { navController.navigate("password") }

        // 📐 Nhóm Layout
        SectionTitle("Layout")
        ButtonItem("Column", "Arranges elements vertically") { navController.navigate("column") }
        ButtonItem("Row", "Arranges elements horizontally") { navController.navigate("row") }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔴 Nút tự tìm hiểu
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFCDD2),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Tự tìm hiểu",
                    fontWeight = FontWeight.Bold
                )
                Text("Tìm ra tất cả các thành phần UI Cơ bản")
            }
        }
    }
}

@Composable
fun ButtonItem(title: String, desc: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFBBDEFB),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(desc, fontSize = 12.sp)
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp)
    )
}
