package com.example.absolute_cinema_app.domain.RegisterRetrfit

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName:String,
    val gender: String,
    val image: String,
    val token: String
)
