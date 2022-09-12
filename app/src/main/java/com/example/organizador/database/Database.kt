package com.example.organizador.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.organizador.database.Dao.EstudoDao
import com.example.organizador.database.Dao.UsuarioDao
import com.example.organizador.database.Entity.Estudo
import com.example.organizador.database.Entity.Usuario

@Database(
    entities = [Usuario::class,
               Estudo::class],
    version = 1,
    exportSchema = true
)

abstract class AppDatabase: RoomDatabase() {

    abstract fun usuarioDao() : UsuarioDao

    abstract fun estudoDao() : EstudoDao


    companion object{
        @Volatile
        private var db : AppDatabase? = null
        fun instancia (context: Context) : AppDatabase{
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "db.organizador")
                .build().also {
                    db = it
                }
        }
    }
}

