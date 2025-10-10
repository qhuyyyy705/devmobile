package com.example.thuchanh2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var edtSoLuong: EditText
    private lateinit var btnTao: Button
    private lateinit var listContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnTao = findViewById(R.id.btnTao)
        listContainer = findViewById(R.id.listContainer)

        btnTao.setOnClickListener {
            val input = edtSoLuong.text.toString().trim()
            listContainer.removeAllViews() // xóa danh sách cũ

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val n = input.toInt()

                // Giới hạn số lượng để tránh out-of-memory
                if (n > 1000) {
                    Toast.makeText(this, "Số lượng quá lớn!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                for (i in 1..n) {
                    val tv = TextView(this).apply {
                        text = i.toString()
                        textSize = 18f
                        setPadding(20, 20, 20, 20)
                        setBackgroundColor(ContextCompat.getColor(
                            this@MainActivity, android.R.color.holo_red_light))
                        setTextColor(ContextCompat.getColor(
                            this@MainActivity, android.R.color.white))
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }

                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 10, 0, 0)
                    tv.layoutParams = params

                    listContainer.addView(tv)
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Dữ liệu bạn nhập không hợp lệ!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
