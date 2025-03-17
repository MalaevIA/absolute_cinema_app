package com.example.absolute_cinema_app.retroifit

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmAPI {

    @Headers("X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a")
    @GET("api/v2.2/films/{id}")
    suspend fun getFilmById(@Path("id") id: Int):Film
    @Headers("X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a")
    @GET("api/v2.2/films")
    suspend fun getFilmsByGenre(
        @Query("genres") genreId: Int,
    ): FilmResponse
}