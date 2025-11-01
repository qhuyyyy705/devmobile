package com.example.demofirebase.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demofirebase.auth.AuthState
import com.example.demofirebase.auth.AuthViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.demofirebase.R
import com.example.demofirebase.navigation.Screen


val PrimaryBlue = Color(0xFF007AFF)

class LoginScreen(private val navController: NavController) : BaseScreen() {

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val authViewModel: AuthViewModel = viewModel()

        val googleSignInClient = remember { authViewModel.getGoogleSignInClient(context) }
        val currentAuthState = authViewModel.authState

        val googleAuthLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            authViewModel.handleGoogleSignInResult(result.data)
        }

        when (val state = currentAuthState) {

            is AuthState.Loading -> {
                Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(50.dp))
                }
            }

            is AuthState.Success -> {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            }

            is AuthState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize().background(Color.White).padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Đăng nhập thất bại!", color = Color.Red, fontSize = 20.sp)
                    Text(state.message)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { authViewModel.resetState() }) {
                        Text("Thử lại")
                    }
                }
            }

            is AuthState.Initial -> {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(horizontal = 48.dp)
                        .padding(top = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    // 1. UTH Logo (Bọc trong một Box/Card để tạo hình vuông bo góc)
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        modifier = Modifier.size(140.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            // Thay thế R.drawable.uth_logo bằng ảnh chứa chữ UTH
                            Image(
                                painter = painterResource(id = R.drawable.uth_logo),
                                contentDescription = "UTH Logo",
                                modifier = Modifier.size(100.dp) // Kích thước logo bên trong
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp)) // Khoảng cách logo và tên app

                    // 2. SmartTasks Title
                    Text(
                        text = "SmartTasks",
                        color = PrimaryBlue,
                        fontSize = 24.sp, // Kích thước lớn hơn
                        fontWeight = FontWeight.Bold
                    )

                    // 3. App Description
                    Text(
                        text = "A simple and efficient to-do app",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(100.dp)) // Khoảng cách lớn trước Welcome

                    // 4. Welcome Text
                    Text(
                        text = "Welcome",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    // 5. Instruction Text
                    Text(
                        text = "Ready to explore? Log in to get started.",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {
                            val signInIntent = googleSignInClient.signInIntent
                            googleAuthLauncher.launch(signInIntent)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue), // Màu nền xanh
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google), // Bạn cần có ic_google.xml hoặc .png
                            contentDescription = "Google",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            "SIGN IN WITH GOOGLE",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    }


                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "© UTHSmartTasks",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                }
            }
        }
    }
}