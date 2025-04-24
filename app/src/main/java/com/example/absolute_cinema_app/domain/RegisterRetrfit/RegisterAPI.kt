package com.example.absolute_cinema_app.domain.RegisterRetrfit

import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterAPI {
    @POST("/login")
    suspend fun Login(@Body userRequest: UserRequest): User
    @POST("/register")
    suspend fun Register(@Body userRequest: UserRequest): User
}