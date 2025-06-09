package com.example.absolute_cinema_app.domain.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.absolute_cinema_app.data.models.filmsModels.Film
import com.example.absolute_cinema_app.data.models.filmsModels.VideoItem
import com.example.absolute_cinema_app.domain.repos.FilmRepository
import kotlinx.coroutines.launch

class FilmViewModel(private val repository: FilmRepository) : ViewModel() {

    private val _film = mutableStateOf<Film?>(null)
    val film: State<Film?> = _film

    private val _videos = mutableStateOf<List<VideoItem>>(emptyList())
    val videos: State<List<VideoItem>> = _videos

    fun loadFilm(id: Int) {
        viewModelScope.launch {
            try {
                _film.value = repository.getFilm(id)
                _videos.value = repository.getVideos(id)
            } catch (e: Exception) {
                Log.e("FilmViewModel", "Ошибка: ${e.message}")
            }
        }
    }
}
