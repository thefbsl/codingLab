package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance();


        val register: Button = findViewById(R.id.signup_1)
//        val editName: EditText = findViewById(R.id.editName)
        val editEmail: EditText = findViewById(R.id.email)
        val editPassword: EditText = findViewById(R.id.password)
        register.setOnClickListener() {
            if (editEmail.text.trim().toString().isNotEmpty() || editPassword.text.trim().toString()
                    .isNotEmpty()
            ) {
                createUser(editEmail.text.trim().toString(), editPassword.text.trim().toString())
            } else {
                Toast.makeText(this, "input Required", Toast.LENGTH_LONG).show()
            }
        }
    }

        fun createUser(email:String, password:String) {
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener (this){ task ->
                    if(task.isSuccessful){
                        Log.e("Task Message", "Successful ...");
                    } else{
                        Log.e("Task Message", "Failed"+task.exception)
                    }
                }
        }
    }
