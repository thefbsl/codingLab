package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup: Button = findViewById(R.id.signup)

        signup.setOnClickListener() {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent);
        }

        val signin: Button = findViewById(R.id.signin)

        signin.setOnClickListener() {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent);
        }

    }
}