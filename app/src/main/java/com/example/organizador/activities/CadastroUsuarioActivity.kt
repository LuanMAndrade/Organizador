package com.example.organizador.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.databinding.ActivityCadastroUsuarioBinding

class CadastroUsuarioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroUsuarioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cadastroBotao.setOnClickListener {
            
        }



    }
}