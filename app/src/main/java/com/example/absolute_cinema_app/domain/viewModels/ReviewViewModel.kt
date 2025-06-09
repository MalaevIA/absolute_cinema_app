package com.example.absolute_cinema_app.domain.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.absolute_cinema_app.data.models.filmsModels.Review
import com.example.absolute_cinema_app.domain.repos.FilmRepository
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val repository: FilmRepository
) : ViewModel() {

    private val _reviews = mutableStateOf<List<Review>>(emptyList())
    val reviews: State<List<Review>> = _reviews

    fun loadReviews(filmId: Int) {
        viewModelScope.launch {
            try {
                _reviews.value = repository.getReviews(filmId)
            } catch (e: Exception) {
                Log.e("ReviewVM", "Ошибка: ${e.message}")
            }
        }
    }
}