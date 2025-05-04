package com.example.quickresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        val teacherBtn = findViewById<ConstraintLayout>(R.id.teacherbtn)
        val studentBtn = findViewById<ConstraintLayout>(R.id.studentbtn)

        teacherBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        studentBtn.setOnClickListener {
            startActivity(Intent(this, StudentPortalActivity::class.java))
        }
    }
}
