package com.example.uthsmarttasks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyCodeScreen(viewModel: SharedViewModel, onBack: () -> Unit, onNext: () -> Unit) {

    val focusManager = LocalFocusManager.current
    // Tạo 6 FocusRequester cho 6 ô nhập
    val focusRequesters = remember { List(6) { FocusRequester() } }

    val initialCodeString by viewModel.verificationCode.collectAsState()
    val initialCodeList = initialCodeString.padEnd(6, ' ').take(6).map { it.toString().trim() }

    var code by remember { mutableStateOf(initialCodeList) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.uth_logo),
                    contentDescription = "UTH Logo",
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .aspectRatio(1f)
                        .padding(bottom = 8.dp),
                    alignment = Alignment.Center
                )

                Text(
                    text = "Verify Code",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "Enter the 6-digit code we just sent to your registered email.",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(6) { index ->
                        OutlinedTextField(
                            value = code[index],
                            onValueChange = { newValue ->
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    val newCodeList = code.toMutableList()
                                    newCodeList[index] = newValue
                                    code = newCodeList.toList()

                                    // Logic chuyển Focus
                                    if (newValue.isNotEmpty() && index < 5) {
                                        // Chuyển focus sang ô tiếp theo
                                        focusRequesters[index + 1].requestFocus()
                                    } else if (newValue.isNotEmpty() && index == 5) {
                                        // Nếu là ô cuối cùng, ẩn bàn phím
                                        focusManager.clearFocus()
                                    }
                                }
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .width(45.dp)
                                .height(55.dp)
                                .focusRequester(focusRequesters[index]), // Gán FocusRequester
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val verificationCodeString = code.joinToString(separator = "")
                        viewModel.updateVerificationCode(verificationCodeString)
                        onNext()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}