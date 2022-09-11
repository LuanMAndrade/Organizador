package com.example.organizador.database.Entity

import androidx.room.Entity


@Entity
data class Estudo(
    val usuarioID : String,
    val horarios : List<Double>,



)