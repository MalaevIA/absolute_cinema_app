package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmResponseForGenre(
    val items: List<Film>,
    val total: Int,
    val totalPages: Int
)
