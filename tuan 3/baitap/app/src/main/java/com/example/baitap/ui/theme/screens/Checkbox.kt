package com.example.baitap.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checkbox / Radio Demo", color = Color(0xFF2196F3)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {


            // ✅ Checkbox vuông
            var checkedSquare by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = checkedSquare,
                        onValueChange = { checkedSquare = it },
                        role = Role.Checkbox
                    )
            ) {

            }

            // ✅ Checkbox tròn (custom)
            var checkedCircle by remember { mutableStateOf(true) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = checkedCircle,
                        onValueChange = { checkedCircle = it },
                        role = Role.Checkbox
                    )
            ) {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(if (checkedCircle) Color(0xFF2196F3) else Color(0xFFBBDEFB)),
                    contentAlignment = Alignment.Center
                ) {
                    if (checkedCircle) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, // tạm dùng icon nhỏ
                            contentDescription = "checked",
                            tint = Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("RadioButton (chọn 1)", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            // ✅ Radio group
            var selected by remember { mutableStateOf("A") }
            Column {
                listOf("A", "B", "C").forEach { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .toggleable(
                                value = (selected == option),
                                onValueChange = { selected = option },
                                role = Role.RadioButton
                            )
                    ) {
                        RadioButton(
                            selected = (selected == option),
                            onClick = { selected = option },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF2196F3)
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Radio $option", fontSize = 16.sp)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Đã chọn: $selected", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("Checkbox nhóm", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))

            // ✅ Checkbox group
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F6FB))
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    var a by remember { mutableStateOf(true) }
                    var b by remember { mutableStateOf(false) }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = a, onCheckedChange = { a = it })
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Checkbox A")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = b, onCheckedChange = { b = it })
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Checkbox B")
                    }
                }
            }
        }
    }
}
