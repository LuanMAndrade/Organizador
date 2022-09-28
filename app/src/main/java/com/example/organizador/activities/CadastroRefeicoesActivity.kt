package com.example.organizador.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.databinding.ActivityCadastroRefeicoesBinding
import com.example.organizador.databinding.ActivityCadastroUsuarioBinding
class CadastroRefeicoesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroRefeicoesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}


