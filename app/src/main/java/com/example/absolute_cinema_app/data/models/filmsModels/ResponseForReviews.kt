package com.example.absolute_cinema_app.data.models.filmsModels

data class ResponseForReviews (
    val total: Int,
    val totalPages: Int,
    val totalPositiveReviews : Int,
    val totalNegativeReviews : Int,
    val totalNeutralReviews: Int,
    val items: List<Review>
)