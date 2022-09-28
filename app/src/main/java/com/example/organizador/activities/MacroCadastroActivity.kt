package com.example.organizador.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.databinding.ActivityFirstAccessBinding
import com.example.organizador.databinding.ActivityMacroCadastroBinding

class MacroCadastroActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMacroCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}