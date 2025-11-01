package com.example.manalibrary.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manalibrary.model.Student
import com.example.manalibrary.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuanLyScreen(
    students: MutableList<Student>
) {
    var selectedStudent by remember { mutableStateOf(students.first()) }

    ManaLibraryTheme {
        Scaffold(
            bottomBar = {
                NavigationBar(containerColor = Color.White) {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = { Icon(Icons.Default.Home, contentDescription = "Quản lý") },
                        label = { Text("Quản lý") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Default.Book, contentDescription = "DS Sách") },
                        label = { Text("DS Sách") },
                        enabled = false
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Default.Person, contentDescription = "Sinh viên") },
                        label = { Text("Sinh viên") },
                        enabled = false
                    )
                }
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Tiêu đề
                Text(
                    text = "Hệ thống Quản lý Thư viện",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Ô nhập sinh viên + nút thay đổi
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = selectedStudent.name,
                        onValueChange = {},
                        label = { Text("Sinh viên") },
                        singleLine = true,
                        readOnly = true,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            val currentIndex = students.indexOf(selectedStudent)
                            val nextIndex = (currentIndex + 1) % students.size
                            selectedStudent = students[nextIndex]
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Thay đổi", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Danh sách sách
                Text(
                    text = "Danh sách sách",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 140.dp)
                        .background(LightGray, RoundedCornerShape(16.dp))
                        .padding(12.dp)
                ) {
                    if (selectedStudent.borrowedBooks.isEmpty()) {
                        Text(
                            "Bạn chưa mượn quyển sách nào\nNhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            color = TextGray,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {
                        LazyColumn {
                            items(selectedStudent.borrowedBooks) { book ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 6.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(3.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .fillMaxWidth()
                                    ) {
                                        Checkbox(
                                            checked = true,
                                            onCheckedChange = {},
                                            colors = CheckboxDefaults.colors(
                                                checkedColor = DarkRed
                                            )
                                        )
                                        Text(
                                            text = book,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(start = 8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Nút thêm
                Button(
                    onClick = {
                        selectedStudent.borrowedBooks.add(
                            "Sách ${selectedStudent.borrowedBooks.size + 1}"
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(48.dp)
                ) {
                    Text("Thêm", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}
