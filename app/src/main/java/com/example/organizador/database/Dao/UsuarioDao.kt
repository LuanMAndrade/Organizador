package com.example.organizador.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.organizador.database.Entity.Usuario
import kotlinx.coroutines.flow.Flow as Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE id = :id")
    fun searchForId(id: String): Flow<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :id AND senha = :senha")
    suspend fun autentica(id: String, senha: String) : Usuario?


}