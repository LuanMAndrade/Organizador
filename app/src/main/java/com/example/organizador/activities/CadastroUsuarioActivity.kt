package com.example.organizador.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.organizador.database.AppDatabase
import com.example.organizador.database.Entity.Usuario
import com.example.organizador.databinding.ActivityCadastroUsuarioBinding
import kotlinx.coroutines.launch
import java.lang.Exception

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
            val usuarioNovo = Usuario(
                binding.cadastroIdText.text.toString(),
                binding.cadastroNomeText.text.toString(),
                binding.cadastroSenhaText.text.toString()
            )
            lifecycleScope.launch {
                try {
                    usuarioDao.insert(usuarioNovo)
                    finish()
                } catch (e: Exception){
                    Log.e("teste", "$e", )
                    Toast.makeText(this@CadastroUsuarioActivity, "Usuário já existe", Toast.LENGTH_SHORT).show()
                }

            }

        }


    }
}