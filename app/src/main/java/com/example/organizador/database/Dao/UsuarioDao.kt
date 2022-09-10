package com.example.organizador.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.organizador.database.Entity.Usuario

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE id = :id")
    suspend fun searchForId(id : String) : Usuario


}