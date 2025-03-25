package com.example.absolute_cinema_app.domain.FilmsData



data class FilmItem(
    val label: String,
    val icon: Int,
    val genre: String,
    val days_from_the_beginning_of_viewing: Int,
)
