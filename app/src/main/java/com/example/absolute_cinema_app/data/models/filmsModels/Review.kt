package com.example.absolute_cinema_app.data.models.filmsModels

data class Review(
    val kinopoiskId: Int,
    val type : String,
    val date : String,
    val positiveRating: Int,
    val negativeRating: Int,
    val author: String,
    val title: String,
    val description: String
)
