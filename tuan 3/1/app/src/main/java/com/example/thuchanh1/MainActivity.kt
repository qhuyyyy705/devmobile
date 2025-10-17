package com.example.thuchanh1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        var isRed = false

        button.setOnClickListener {
            // Tạo màu ngẫu nhiên
            val randomColor = Color.rgb(
                Random.nextInt(0, 256), // R
                Random.nextInt(0, 256), // G
                Random.nextInt(0, 256)  // B
            )

            // Gán màu cho TextView
            textView.setTextColor(randomColor)
        }
    }
}