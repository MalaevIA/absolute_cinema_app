package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmResponseForSimilars(
    val total : Int,
    val items: List<FilmForSimilars>
)
