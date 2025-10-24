package com.example.uthsmarttasks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

@Composable
fun OnBoard2Screen(navController: NavController) {
    val primaryColor = MaterialTheme.colorScheme.primary // Lấy màu chính từ theme

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // --- Top section: Chỉ còn Progress Dots và "Skip" ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 24.dp, end = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Chấm tròn tiến độ: Đánh dấu vị trí thứ 2
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                // Dot 1: Inactive
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                // Dot 2: Active
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(primaryColor)
                )
                // Dot 3: Inactive
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
            }

            // "Skip" button (giữ lại ở góc trên bên phải)
            TextButton(onClick = {
                navController.navigate("home") {
                    popUpTo("onboard2") { inclusive = true }
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
                painter = painterResource(id = R.drawable.onboard_2),
                contentDescription = "Increase Work Effectiveness Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Title
            Text(
                text = "Increase Work Effectiveness",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = "Time management and determining important tasks help improve your work performance and efficiency.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Spacer to push the button down
            Spacer(modifier = Modifier.weight(1f))
        }

        // --- Bottom Buttons (Back and Next) ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // =======================================================
            // ⬇️ NÚT BACK (MÀU XANH TỪ THEME) ⬇️
            Button(
                onClick = { navController.popBackStack() }, // Quay lại màn hình trước (onboard1)
                modifier = Modifier
                    .size(56.dp), // Kích thước cố định cho nút tròn
                shape = CircleShape, // Hình tròn
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor.copy(alpha = 0.1f), // Màu nền nhạt (xanh)
                    contentColor = primaryColor // Màu icon/chữ là primary color (xanh)
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = primaryColor
                )
            }
            // ⬆️ KẾT THÚC NÚT BACK ⬆️
            // =======================================================

            Spacer(modifier = Modifier.width(16.dp))

            // "Next" Button
            Button(
                onClick = { navController.navigate("onboard3") }, // Chuyển sang onboard3
                modifier = Modifier
                    .weight(1f) // Chiếm phần còn lại của không gian
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}