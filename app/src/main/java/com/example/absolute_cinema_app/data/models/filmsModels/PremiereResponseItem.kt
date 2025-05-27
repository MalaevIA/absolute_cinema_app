package com.example.absolute_cinema_app.data.models.filmsModels

data class PremiereResponseItem(
    val kinopoiskId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val year: Int?,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val genres: List<Genre>,
    val duration: Int?,
    val premiereRu: String?
)
