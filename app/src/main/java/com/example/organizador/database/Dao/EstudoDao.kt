package com.example.organizador.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.organizador.database.Entity.Estudo


@Dao
interface EstudoDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(estudo: Estudo)

    @Delete
    suspend fun delete(estudo: Estudo)

    @Query("SELECT * FROM Estudo WHERE usuarioID = :usuarioId")
    suspend fun searchForId(usuarioId: String) : Estudo



}