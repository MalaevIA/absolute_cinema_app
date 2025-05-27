package com.example.absolute_cinema_app.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("ContinueFilms")
data class FilmEntity(
    @PrimaryKey
    val id:Int,
    val poster:String?,
    val genre: String?,
    val label:String?,
    val addedAt: Long = System.currentTimeMillis()
)
