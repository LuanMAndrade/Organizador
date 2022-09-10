package com.example.organizador.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.organizador.database.AppDatabase
import com.example.organizador.database.Entity.Usuario
import com.example.organizador.databinding.ActivityCadastroUsuarioBinding
import kotlinx.coroutines.launch

class CadastroUsuarioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroUsuarioBinding.inflate(layoutInflater)
    }


    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cadastroBotao.setOnClickListener {
            val usuarioNovo = Usuario("as", "as", "as")
            lifecycleScope.launch {
                usuarioDao.insert(usuarioNovo)
            }

        }


    }
}