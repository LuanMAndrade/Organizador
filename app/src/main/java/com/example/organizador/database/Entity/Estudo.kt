package com.example.organizador.database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Estudo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var nome: String,
    var horario: Int,
    var duracao: Int,
    val usuarioID: String,
    var feito: Boolean = false
)