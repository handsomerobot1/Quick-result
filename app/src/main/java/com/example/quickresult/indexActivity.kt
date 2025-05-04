package com.example.quickresult

import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.GridLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class indexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_index)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        val rows = 10
        val columns = 6
        gridLayout.columnCount = columns

        for (i in 0 until rows) {
            for (j in 0 until columns) {
                val cell = EditText(this).apply {
                    width = 200
                    height = 120
                    hint = "R${i + 1}C${j + 1}"
                    gravity = Gravity.CENTER
                    setPadding(8, 8, 8, 8)
                    setBackgroundResource(android.R.drawable.edit_text)
                }
                gridLayout.addView(cell)
            }

        }
    }
}
