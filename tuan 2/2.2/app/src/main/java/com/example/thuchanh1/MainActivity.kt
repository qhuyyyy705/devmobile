package com.example.thuchanh1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view trong layout
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnCheck = findViewById(R.id.btnCheck)
        txtResult = findViewById(R.id.txtResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val ageText = edtAge.text.toString().trim()

            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ họ tên và tuổi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val age = ageText.toInt()
                val type = when {
                    age > 65 -> "Người già"
                    age in 6..65 -> "Người lớn"
                    age in 2..6 -> "Trẻ em"
                    else -> "Em bé"
                }

                txtResult.text = "Xin chào $name\nBạn thuộc nhóm: $type"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Tuổi nhập không hợp lệ!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
