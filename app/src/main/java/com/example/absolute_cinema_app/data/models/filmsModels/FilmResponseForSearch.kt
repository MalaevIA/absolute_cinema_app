package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmResponseForSearch(
    val keyword: String,
    val pagesCount: Int,
    val searchFilmsCountResult: Int,
    val films: List<FilmForSearch>
)
