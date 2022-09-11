package com.example.organizador.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.example.organizador.R
import com.example.organizador.dataStore
import com.example.organizador.database.AppDatabase
import com.example.organizador.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val map: MutableMap<String, Int> = mutableMapOf()
        map["one"] = 1
        map["two"] = 2
        map["three"] = 3

        Log.i("teste", "${map.values}")





        lifecycleScope.launch {
            dataStore.data.collect { preferences ->
                preferences[stringPreferencesKey("usuarioLogado")]?.let { usuarioId ->
                    val usuarioLogado = usuarioDao.searchForId(usuarioId)
                } ?: startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }
        }


        binding.cardAlimentacao.visibility = View.GONE

        binding.cardAlimentacao.setOnClickListener {}
        binding.cardEstudo.setOnClickListener {
            startActivity(Intent(this, CadastroEstudoActivity::class.java))
        }
        binding.cardTarefas.setOnClickListener { }
        binding.cardOutros.setOnClickListener { }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_menu_exit -> {
                lifecycleScope.launch {
                    dataStore.edit { preferences ->
                        preferences.remove(stringPreferencesKey("usuarioLogado"))
                    }
                }
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}