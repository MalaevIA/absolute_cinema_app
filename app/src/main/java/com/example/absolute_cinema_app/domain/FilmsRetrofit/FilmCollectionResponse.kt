package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class FilmCollectionResponse(
    val items: List<FilmCollectionResponse_item>,
    val total: Int,
    val totalPages: Int
)
