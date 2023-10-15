package com.example.loginapp.quickstart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.R
import com.example.loginapp.databinding.ActivityQuickStart2Binding

class QuickStart2 : AppCompatActivity() {

    private lateinit var binding: ActivityQuickStart2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickStart2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonClick()
    }

    private fun buttonClick() {
        binding.btBackPg2.setOnClickListener{
            intent = Intent(this, QuickStart1::class.java)
            startActivity(intent)
        }
        binding.btNextPg2.setOnClickListener{
            intent = Intent(this, QuickStart3::class.java)
            startActivity(intent)
        }
    }
}