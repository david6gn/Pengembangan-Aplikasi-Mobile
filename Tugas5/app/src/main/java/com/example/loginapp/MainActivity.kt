package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.quickstart.QuickStart1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        sp = applicationContext.getSharedPreferences("UserData", Context.MODE_PRIVATE)

        if (!sp.getBoolean("IsOpened", false)) {
            intent = Intent(this, QuickStart1::class.java)
            startActivity(intent)
        } else if (!sp.getBoolean("IsLogin", false)) {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        val welcomeMsg = getString(R.string.welcome, sp.getString("username", ""))
        binding.mainText.text = welcomeMsg
        setContentView(binding.root)

        buttonClick()
    }

    private fun buttonClick() {
        binding.btLogout.setOnClickListener{
            val editor: SharedPreferences.Editor = sp.edit()
            editor.remove("IsLogin")
            editor.apply()
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }


}