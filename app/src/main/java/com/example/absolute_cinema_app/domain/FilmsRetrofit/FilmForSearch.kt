package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class FilmForSearch(
    val filmId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val nameOriginal: String?,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val ratingKinopoisk: Double?,
    val ratingImdb: Double?,
    val year: Int?,
    val filmLength: String?,
    val description: String?,
    val genres: List<Genre>
)