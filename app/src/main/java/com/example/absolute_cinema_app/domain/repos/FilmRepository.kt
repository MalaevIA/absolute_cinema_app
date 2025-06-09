package com.example.absolute_cinema_app.domain.repos

import com.example.absolute_cinema_app.data.models.filmsModels.Film
import com.example.absolute_cinema_app.data.models.filmsModels.FilmForSimilars
import com.example.absolute_cinema_app.data.models.filmsModels.Review
import com.example.absolute_cinema_app.data.models.filmsModels.VideoItem
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI

class FilmRepository(private val api: FilmAPI) {
    suspend fun getReviews(filmId: Int): List<Review> {
        return api.getReviewsToFilmById(filmId).items
    }
    suspend fun getSimilarFilms(filmId: Int): List<FilmForSimilars> {
        return api.getSimilarsFilmsById(filmId).items
    }
    suspend fun getFilm(id: Int): Film = api.getFilmById(id)

    suspend fun getVideos(id: Int): List<VideoItem> = api.getVideoForFilmById(id).items
}
