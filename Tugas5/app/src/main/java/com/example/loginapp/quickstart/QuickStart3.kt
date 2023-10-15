package com.example.loginapp.quickstart

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.R
import com.example.loginapp.SignIn
import com.example.loginapp.databinding.ActivityQuickStart3Binding

class QuickStart3 : AppCompatActivity() {

    private lateinit var binding: ActivityQuickStart3Binding
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickStart3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = applicationContext.getSharedPreferences("UserData", Context.MODE_PRIVATE)
        buttonClick()
    }

    private fun buttonClick() {
        binding.btBackPg3.setOnClickListener{
            intent = Intent(this, QuickStart2::class.java)
            startActivity(intent)
        }

        binding.btFinishPg3.setOnClickListener {
            val editor: SharedPreferences.Editor = sp.edit()
            editor.putBoolean("IsOpened", true)
            editor.apply()
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}