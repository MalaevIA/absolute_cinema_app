package com.example.absolute_cinema_app.domain.FilmsRetrofit

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
