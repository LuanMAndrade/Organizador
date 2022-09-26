package com.example.organizador.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.example.organizador.R
import com.example.organizador.dataStore
import com.example.organizador.database.AppDatabase
import com.example.organizador.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val usuarioDao by lazy {
        AppDatabase.instancia(this).usuarioDao()
    }

    private val estudoDao by lazy {
        AppDatabase.instancia(this).estudoDao()
    }

    @SuppressLint("ClickableViewAccessibility", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


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
            startActivity(Intent(this, TesteCameraActivity::class.java))
        }
        binding.cardOutros.setOnClickListener {
        }
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