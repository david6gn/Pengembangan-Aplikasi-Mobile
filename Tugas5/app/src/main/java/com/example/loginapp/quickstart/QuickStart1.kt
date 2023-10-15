package com.example.loginapp.quickstart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.R
import com.example.loginapp.databinding.ActivityQuickStart1Binding

class QuickStart1 : AppCompatActivity() {

    private lateinit var binding: ActivityQuickStart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickStart1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonClick()
    }

    private fun buttonClick() {
        binding.btNextPg1.setOnClickListener {
            intent = Intent(this, QuickStart2::class.java)
            startActivity(intent)
        }
    }
}