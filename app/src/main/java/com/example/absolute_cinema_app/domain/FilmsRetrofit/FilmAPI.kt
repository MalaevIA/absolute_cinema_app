package com.example.absolute_cinema_app.domain.FilmsRetrofit

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmAPI {

    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")// сделать скрипт с заменой ключей API
    @GET("api/v2.2/films/{id}")
    suspend fun getFilmById(@Path("id") id: Int): Film
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.2/films")
    suspend fun getFilmsByGenre(
        @Query("genres") genreId: Int,
    ): FilmResponseForGenre
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.1/films/search-by-keyword")
    suspend fun getFilmsByKeyword(
        @Query("keyword") keyword: String,
        @Query("page") page: Int = 1
    ): FilmResponseForSearch
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.2/films/{id}/similars")
    suspend fun getSimilarsFilmsById(
        @Path("id")id: Int
    ):FilmResponseForSimilars
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.2/films/{id}/videos")
    suspend fun getVideoForFilmById(
        id: Int
    )//дописать
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.2/films/{id}/reviews")
    suspend fun getReviewsToFilmById(
        @Path("id")id: Int
    ):ResponseForReviews
    @Headers("X-API-KEY: 90880331-6131-4071-84ae-3e26f84cfbbc")
    @GET("api/v2.2/films/{id}/awards")
    suspend fun getAwardsToFilmById(
        id: Int
    )//дописать
    @Headers("X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a")
    @GET("api/v2.2/films/collections")
    suspend fun getTopPopularFilms(
        @Query("type") type: String = "TOP_POPULAR_ALL",
        @Query("page") page: Int = 1
    ):FilmCollectionResponse
    @Headers("X-API-KEY: 87ce625c-ef38-47cd-a704-5c54679b209a")
    @GET("api/v2.2/films/premieres")
    suspend fun getPremieres(
        @Query("year") year: Int,
        @Query("month") month: String
    ): PremiereResponse
}