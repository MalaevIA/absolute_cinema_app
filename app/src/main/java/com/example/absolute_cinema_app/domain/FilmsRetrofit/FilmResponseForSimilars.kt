package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class FilmResponseForSimilars(
    val total : Int,
    val items: List<FilmForSimilars>
)
