package com.example.organizador.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.R
import com.example.organizador.databinding.ActivityLoginBinding
import com.example.organizador.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        binding.loginEntrar.setOnClickListener{
//
//        }
        binding.loginCadastro.setOnClickListener{
            startActivity(Intent(this,CadastroUsuarioActivity::class.java))
        }


    }
}