package com.example.uthsmarttasks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

@Composable
fun OnBoard3Screen(navController: NavController) {
    val primaryColor = MaterialTheme.colorScheme.primary // Lấy màu chính từ theme
    val contentColor = MaterialTheme.colorScheme.onSurface // Màu chữ cho nội dung chính

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // --- Top section with progress dots and skip button ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Chấm tròn tiến độ: Đánh dấu vị trí thứ 3
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                // Dot 1: Inactive
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                // Dot 2: Inactive
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                // Dot 3: Active (Màn hình hiện tại)
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(primaryColor) // <<--- Dùng primary color
                )
            }

            // "Skip" button
            TextButton(onClick = {
                navController.navigate("home") {
                    popUpTo("onboard3") { inclusive = true }
                }
            }) {
                Text(
                    text = "skip",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        // --- Main content column ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 100.dp, bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.onboard_3), // <<--- Sử dụng onboard_3
                contentDescription = "Reminder Notification Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Title: Cập nhật nội dung cho màn hình 3
            Text(
                text = "Reminder Notification",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description: Cập nhật nội dung cho màn hình 3
            Text(
                text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Spacer to push the buttons down
            Spacer(modifier = Modifier.weight(1f))
        }

        // --- Buttons at the bottom (Back and Get Started) ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // =======================================================
            // ⬇️ DÒNG CODE CHO NÚT BACK ⬇️
            Button(
                onClick = { navController.popBackStack() }, // Quay lại màn hình trước
                modifier = Modifier
                    .size(56.dp), // Kích thước cố định cho nút tròn
                shape = CircleShape, // Hình tròn
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor.copy(alpha = 0.1f), // Màu nền nhạt hơn primary
                    contentColor = primaryColor // Màu icon/chữ là primary color
                ),
                contentPadding = PaddingValues(0.dp) // Loại bỏ padding mặc định
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, // Icon mũi tên quay lại
                    contentDescription = "Back",
                    tint = primaryColor // Màu icon là primary color
                )
            }
            // ⬆️ KẾT THÚC DÒNG CODE CHO NÚT BACK ⬆️
            // =======================================================

            Spacer(modifier = Modifier.width(16.dp)) // Khoảng cách giữa hai nút

            // "Get Started"
            Button(
                onClick = {
                    navController.navigate("Splash") { // Điều hướng đến màn hình chính
                        popUpTo("onboard3") { inclusive = true } // Xóa tất cả các màn hình onboard khỏi back stack
                    }
                },
                modifier = Modifier
                    .weight(1f) // Chiếm phần còn lại của không gian
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp), // Bo tròn nhiều hơn
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor, // Dùng primary color từ theme
                    contentColor = MaterialTheme.colorScheme.onPrimary // Màu chữ phù hợp
                )
            ) {
                Text(
                    text = "Get Started",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}