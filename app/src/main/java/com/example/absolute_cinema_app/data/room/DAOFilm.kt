package com.example.absolute_cinema_app.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOFilm {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(filmEntity: FilmEntity)
    @Delete
    suspend fun deleteFilm(filmEntity: FilmEntity)
    @Query("SELECT * FROM ContinueFilms ORDER BY addedAt DESC")
    fun getAllFilms(): Flow<List<FilmEntity>>

}