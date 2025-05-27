package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmForSimilars(
    val filmId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val relationType: String
)
