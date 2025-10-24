package com.example.manalibrary.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.manalibrary.model.Student

@Composable
fun SinhVienScreen(students: MutableList<Student>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Danh sách Sinh viên", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(students) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(student.name, fontWeight = FontWeight.Bold)
                        Text("Sách mượn: ${student.borrowedBooks.joinToString(", ").ifEmpty { "Chưa có" }}")
                    }
                }
            }
        }
    }
}
