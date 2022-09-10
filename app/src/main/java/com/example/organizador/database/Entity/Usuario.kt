package com.example.organizador.database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario(
    @PrimaryKey
    private val id: String,
    private val nome: String,
    private val senha: String
    )