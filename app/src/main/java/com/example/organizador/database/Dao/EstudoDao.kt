package com.example.organizador.database.Dao

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface EstudoDao {

    @Insert
    fun insert()

}