package com.example.organizador.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.organizador.databinding.ActivityCadastroEstudoBinding

class CadastroEstudoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroEstudoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}