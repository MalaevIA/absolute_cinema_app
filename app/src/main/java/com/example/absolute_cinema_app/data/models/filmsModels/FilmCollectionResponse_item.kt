package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmCollectionResponse_item(
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val genres: List<Genre>,
    val ratingKinopoisk: Double?,
    val ratingImbd: Double?,
    val year: String?,
    val type: String?,
    val posterUrl: String?,
    val posterUrlPreview: String?
)
