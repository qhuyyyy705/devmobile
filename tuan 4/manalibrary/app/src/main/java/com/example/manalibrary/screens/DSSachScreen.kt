package com.example.manalibrary.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.manalibrary.model.Book

@Composable
fun DSSachScreen(books: MutableList<Book>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Danh sách Sách", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(books) { book ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = book.title,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
