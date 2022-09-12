package com.example.organizador.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.organizador.database.AppDatabase
import com.example.organizador.database.Entity.Estudo
import com.example.organizador.databinding.ActivityCadastroEstudoBinding
import kotlinx.coroutines.launch

class CadastroEstudoActivity : AppCompatActivity() {

    private val estudoDao by lazy {
        AppDatabase.instancia(this).estudoDao()
    }

    private val binding by lazy {
        ActivityCadastroEstudoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.cadastroEstudoBotao.setOnClickListener {
            val nome = binding.cadastroEstudoNomeText.text.toString()
            val horario = binding.cadastroEstudoHorarioText.text.toString().toInt()
            val duracao = binding.cadastroEstudoDuracaoText.text.toString().toInt()
            val usuarioID = "hieyandrade"
            val novoEstudo = Estudo(
                nome = nome,
                horario = horario,
                duracao = duracao,
                usuarioID = usuarioID)
            lifecycleScope.launch { estudoDao.insert(novoEstudo) }
            finish()

        }
    }
}