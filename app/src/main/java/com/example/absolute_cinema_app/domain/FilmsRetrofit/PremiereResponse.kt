package com.example.absolute_cinema_app.domain.FilmsRetrofit

data class PremiereResponse(
    val total: Int,
    val items: List<PremiereResponseItem>
)

