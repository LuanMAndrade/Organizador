package com.example.organizador.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.example.organizador.dataStore
import com.example.organizador.database.AppDatabase
import com.example.organizador.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginBotaoEntrar.setOnClickListener {
            val id = binding.loginInputLoginText.text.toString()
            val senha = binding.loginInputSenhaText.text.toString()
            lifecycleScope.launch {
                val usuarioAutenticado = usuarioDao.autentica(id, senha)
                usuarioAutenticado?.let { usuario ->
                    Log.i("teste", "foi")
                    dataStore.edit { preferences ->
                        preferences[stringPreferencesKey("usuarioLogado")] = usuario.id
                    }
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                } ?: Toast.makeText(
                    this@LoginActivity,
                    "Usuário ou senha incorretos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.loginBotaoCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroUsuarioActivity::class.java))
        }


    }
}