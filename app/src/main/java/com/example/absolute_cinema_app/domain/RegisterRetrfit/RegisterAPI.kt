package com.example.absolute_cinema_app.domain.RegisterRetrfit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header

import retrofit2.http.POST

interface RegisterAPI {
    @POST("/login")
    suspend fun Login(@Body userRequest: UserRequest): User
    @POST("/register")
    suspend fun Register(@Body userRequest: UserRequest): User
    @POST("/favorites/add")
    suspend fun addToFavorites(
        @Header("Authorization") token: String,
        @Body request: FavoriteRequest
    ): Response<Void>

    @GET("/favorites")
    suspend fun getFavorites(
        @Header("Authorization") token: String
    ): Response<FavoriteResponse>

    @HTTP(method = "DELETE", path = "/favorites/remove", hasBody = true)
    suspend fun removeFromFavorites(
        @Body request: FavoriteRequest,
        @Header("Authorization") token: String
    ): Response<Unit>
}