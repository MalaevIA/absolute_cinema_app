package com.example.absolute_cinema_app.data.models.filmsModels

data class FilmCollectionResponse(
    val items: List<FilmCollectionResponse_item>,
    val total: Int,
    val totalPages: Int
)
