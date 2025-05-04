package com.example.quickresult

import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class indexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)

        // Get values from intent
        val subjectCount = intent.getIntExtra("SUBJECT_COUNT", 0)
        val studentCount = intent.getIntExtra("STUDENT_COUNT", 0)

        // Add 1 to subjectCount for the header row
        val rows = studentCount + 1  // +1 for header row
        val columns = subjectCount + 1  // +1 for student names column

        gridLayout.columnCount = columns

        // Create header row (subject names)
        for (j in 0 until columns) {
            val cell = if (j == 0) {
                TextView(this).apply {
                    text = "Student"
                }
            } else {
                TextView(this).apply {
                    text = "Sub $j"
                }
            }
            cell.apply {
                width = 200
                height = 120
                gravity = Gravity.CENTER
                setPadding(8, 8, 8, 8)
                setBackgroundResource(android.R.drawable.edit_text)
            }
            gridLayout.addView(cell)
        }

        // Create student rows
        for (i in 1 until rows) {
            for (j in 0 until columns) {
                val cell = if (j == 0) {
                    // First column - student name/number
                    TextView(this).apply {
                        text = "Student $i"
                    }
                } else {
                    // Subject columns - editable fields
                    EditText(this).apply {
                        hint = "Marks"
                    }
                }
                cell.apply {
                    width = 200
                    height = 120
                    gravity = Gravity.CENTER
                    setPadding(8, 8, 8, 8)
                    setBackgroundResource(android.R.drawable.edit_text)
                }
                gridLayout.addView(cell)
            }
        }
    }
}