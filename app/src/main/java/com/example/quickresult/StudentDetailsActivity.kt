package com.example.quickresult

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar


class StudentDetailsActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_student_details)

            val spinnerSession = findViewById<Spinner>(R.id.spinnerSession)
            val nameEditText = findViewById<EditText>(R.id.editTextName)
            val subjectPicker = findViewById<NumberPicker>(R.id.subjectNumberPicker)
            val studentPicker = findViewById<NumberPicker>(R.id.studentNumberPicker)
            val submitBtn = findViewById<Button>(R.id.submitBtn)



            // Setup Session Spinner (2020 - Current Year)
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val sessions = (currentYear..2050).map { it.toString() }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sessions)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSession.adapter = adapter

            // Subject Picker (1 to 100)
            subjectPicker.minValue = 1
            subjectPicker.maxValue = 100

            // Student Picker (1 to 2000)
            studentPicker.minValue = 1
            studentPicker.maxValue = 2000

            // In StudentDetailsActivity's submitBtn.setOnClickListener
            submitBtn.setOnClickListener {
                val session = spinnerSession.selectedItem.toString()
                val name = nameEditText.text.toString()
                val subjectNo = subjectPicker.value
                val studentNo = studentPicker.value

                if (name.isBlank()) {
                    Toast.makeText(this, "Please enter a class name.", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, indexActivity::class.java)
                    intent.putExtra("SUBJECT_COUNT", subjectNo)
                    intent.putExtra("STUDENT_COUNT", studentNo)
                    startActivity(intent)
                }

            }

        }
    }
