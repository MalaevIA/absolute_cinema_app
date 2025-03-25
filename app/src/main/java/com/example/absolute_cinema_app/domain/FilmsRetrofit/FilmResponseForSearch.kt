package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class FilmResponseForSearch(
    val keyword: String,
    val pagesCount: Int,
    val searchFilmsCountResult: Int,
    val films: List<Film>
)
