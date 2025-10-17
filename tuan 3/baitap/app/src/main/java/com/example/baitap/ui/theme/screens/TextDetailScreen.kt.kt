package com.example.baitap.ui.theme.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextDetailScreen() {
    val styledText = buildAnnotatedString {
        append("The ")

        // quick (gạch ngang)
        withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
            append("quick ")
        }

        // Brown (in đậm và màu nâu)
        withStyle(style = SpanStyle(color = Color(0xFFB87333), fontWeight = FontWeight.Bold)) {
            append("Brown\n")
        }

        // fox jumps
        append("fox j u m p s ")

        // over (in đậm)
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("over\n")
        }

        // the
        append("the ")

        // lazy (in nghiêng)
        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
            append("lazy ")
        }

        append("dog.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Text Detail",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = styledText,
            fontSize = 22.sp,
            lineHeight = 32.sp
        )
    }
}
