package com.example.thuchanh2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var btnCheck: Button
    private lateinit var txtError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        btnCheck = findViewById(R.id.btnCheck)
        txtError = findViewById(R.id.txtError)

        btnCheck.setOnClickListener {
            val email = edtEmail.text.toString().trim()

            when {
                email.isEmpty() -> {
                    txtError.text = "Email không hợp lệ"
                    txtError.visibility = TextView.VISIBLE
                }
                !email.contains("@") -> {
                    txtError.text = "Email không đúng định dạng"
                    txtError.visibility = TextView.VISIBLE
                }
                else -> {
                    txtError.text = "Bạn đã nhập email hợp lệ"
                    txtError.setTextColor(getColor(android.R.color.holo_green_dark))
                    txtError.visibility = TextView.VISIBLE
                }
            }
        }
    }
}
