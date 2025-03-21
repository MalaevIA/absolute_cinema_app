package com.example.absolute_cinema_app.retroifit.RegisterRetrfit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegisterAPI {
    @POST("auth/login")
    suspend fun Register(@Body userRequest: UserRequest): User
}