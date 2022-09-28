package com.example.organizador.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.databinding.ActivityFirstAccessBinding

class FirstAccessActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFirstAccessBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.macro.setOnClickListener {
            startActivity(Intent(this, MacroCadastroActivity::class.java))
        }
    }


}