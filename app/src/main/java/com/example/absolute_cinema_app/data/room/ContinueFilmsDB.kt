package com.example.absolute_cinema_app.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [
        FilmEntity::class
    ],
    version = 3
)
abstract class ContinueFilmsDB:RoomDatabase(){
    abstract val dao: DAOFilm

    companion object{
        fun CreateDB(context: Context): ContinueFilmsDB {
            return Room.databaseBuilder(context, ContinueFilmsDB::class.java,"films.db").fallbackToDestructiveMigration().build()
        }
    }
}