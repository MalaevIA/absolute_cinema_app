package com.example.absolute_cinema_app.domain.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.absolute_cinema_app.data.models.filmsModels.FilmForSimilars
import com.example.absolute_cinema_app.domain.repos.FilmRepository
import kotlinx.coroutines.launch

class SimilarFilmsViewModel(
    private val repository: FilmRepository
) : ViewModel() {

    private val _similarFilms = mutableStateOf<List<FilmForSimilars>>(emptyList())
    val similarFilms: State<List<FilmForSimilars>> = _similarFilms

    fun loadSimilarFilms(id: Int) {
        viewModelScope.launch {
            try {
                _similarFilms.value = repository.getSimilarFilms(id)
            } catch (e: Exception) {
                Log.e("SimilarFilmsVM", "Ошибка загрузки: ${e.message}")
            }
        }
    }
}