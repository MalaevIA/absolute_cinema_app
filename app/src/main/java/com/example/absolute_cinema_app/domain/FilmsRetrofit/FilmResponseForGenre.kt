package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class FilmResponseForGenre(
    val items: List<Film>,
    val total: Int,
    val totalPages: Int
)
