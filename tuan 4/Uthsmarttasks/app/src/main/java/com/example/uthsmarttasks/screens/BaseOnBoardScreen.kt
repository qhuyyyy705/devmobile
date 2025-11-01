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

abstract class BaseOnBoardScreen(
    protected val navController: NavController
) {

    /** Các thuộc tính để các class con override */
    abstract val imageRes: Int
    abstract val title: String
    abstract val description: String
    abstract val currentPage: Int
    abstract val totalPages: Int

    /** Hành vi nút */
    open fun onNext() {}
    open fun onBack() {}
    open fun onSkip() {}

    @Composable
    open fun Content() {
        val primaryColor = MaterialTheme.colorScheme.primary

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // --- Top: Dots + Skip ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    repeat(totalPages) { index ->
                        Spacer(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(if (index == currentPage) primaryColor else Color.LightGray)
                        )
                    }
                }

                TextButton(onClick = { onSkip() }) {
                    Text("Skip", color = Color.Gray)
                }
            }

            // --- Nội dung chính ---
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 100.dp, bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .aspectRatio(1f)
                )

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            // --- Buttons ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { onBack() },
                    modifier = Modifier.size(56.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor.copy(alpha = 0.1f),
                        contentColor = primaryColor
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = primaryColor)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { onNext() },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = if (currentPage == totalPages - 1) "Get Started" else "Next",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
