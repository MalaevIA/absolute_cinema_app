package com.example.absolute_cinema_app.retroifit.FilmsRetrofit

data class FilmResponse2(
    val keyword: String,
    val pagesCount: Int,
    val searchFilmsCountResult: Int,
    val films: List<Film>
)
