package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        sp = applicationContext.getSharedPreferences("UserData", Context.MODE_PRIVATE)
        setContentView(binding.root)

        buttonClick()
    }

    private fun buttonClick() {
        binding.buttonSu.setOnClickListener{
            val username = binding.inputUsernameSu.text.toString()
            val password = binding.inputPassword.text.toString()
            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Input username and password!", Toast.LENGTH_LONG).show()
            } else {
                val editor: SharedPreferences.Editor = sp.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.putBoolean("IsLogin", false)
                editor.apply()

                Toast.makeText(this,"Successfully Sign Up",Toast.LENGTH_LONG).show()

                intent = Intent(this, SignIn::class.java)
                startActivity(intent)
            }

        }
    }
}