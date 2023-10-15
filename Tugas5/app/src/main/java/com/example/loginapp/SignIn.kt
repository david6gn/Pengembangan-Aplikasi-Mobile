package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginapp.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        sp = getSharedPreferences("UserData", Context.MODE_PRIVATE)


        setContentView(binding.root)
        buttonClick()
    }

    private fun buttonClick() {
        binding.btSi.setOnClickListener{
            val inputuser = binding.InputUsername.text.toString()
            val inputpw = binding.InputPassword.text.toString()

            if (inputuser == sp.getString("username", "") && inputpw == sp.getString("password", "")) {
                if (sp.getString("username", "") == "") {
                    Toast.makeText(this, "There's no data, Sign Up first!", Toast.LENGTH_LONG).show()
                } else if (sp.getString("username", "") != "") {
                    val editor: SharedPreferences.Editor = sp.edit()
                    editor.putBoolean("IsLogin", true)
                    editor.apply()
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this,"Incorrect Username or Password", Toast.LENGTH_LONG).show()
            }

        }

        binding.btSu.setOnClickListener{
            intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}