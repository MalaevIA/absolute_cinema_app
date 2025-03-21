package com.example.absolute_cinema_app.retroifit.FilmsRetrofit

data class FilmResponse(
    val items: List<Film>,
    val total: Int,
    val totalPages: Int
)
