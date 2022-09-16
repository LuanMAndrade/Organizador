package com.example.organizador.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.organizador.R
import com.example.organizador.databinding.ActivityEstudoBinding

class EstudoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityEstudoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_estudo_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_estudo_add -> {
                startActivity(Intent(this,CadastroEstudoActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }


}