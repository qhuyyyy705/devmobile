package com.example.uthsmarttasks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun OnBoard1Screen(navController: NavController) {
    val primaryColor = MaterialTheme.colorScheme.primary

    // Sử dụng Box làm container chính và đặt màu nền trắng rõ ràng
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // <<--- ĐÃ ĐẶT MÀU NỀN TRẮNG
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 40.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 🔹 Hàng trên: indicator + Skip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Chấm tròn tiến độ
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Dot 1: Active
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(primaryColor)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    // Dot 2: Inactive
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    // Dot 3: Inactive
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )
                }

                // Nút Skip
                Text(
                    text = "Skip",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.clickable {
                        navController.navigate("home") {
                            popUpTo("onboard1") { inclusive = true }
                        }
                    }
                )
            }

            // 🔹 Nội dung chính (Ảnh + Mô tả)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                // Ảnh minh họa
                Image(
                    painter = painterResource(id = R.drawable.onboard_1),
                    contentDescription = "Easy Time Management",
                    modifier = Modifier
                        .fillMaxWidth(0.8f) // <<--- KÍCH CỠ ẢNH: chiếm 80% chiều rộng
                        .aspectRatio(1f)   // <<--- KÍCH CỠ ẢNH: đảm bảo ảnh là hình vuông
                )

                Spacer(modifier = Modifier.height(48.dp))

                // Tiêu đề
                Text(
                    text = "Easy Time Management",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Mô tả
                Text(
                    text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp) // Thêm padding cho text mô tả
                )
            }

            // 🔹 Nút Next (ở dưới cùng, chiếm toàn bộ chiều rộng)
            Button(
                onClick = { navController.navigate("onboard2") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), // Chiều cao chuẩn
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                shape = RoundedCornerShape(28.dp) // Bo tròn nhiều hơn
            ) {
                Text(
                    text = "Next",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}