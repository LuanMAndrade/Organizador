package com.example.organizador.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.organizador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.cardAlimentacao.visibility = View.GONE

            binding.cardAlimentacao.setOnClickListener {}
            binding.cardEstudo.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            }
            binding.cardTarefas.setOnClickListener { }
            binding.cardOutros.setOnClickListener { }

    }
}