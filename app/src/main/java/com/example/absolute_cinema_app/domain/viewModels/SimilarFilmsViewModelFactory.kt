package com.example.absolute_cinema_app.domain.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.absolute_cinema_app.domain.repos.FilmRepository

class SimilarFilmsViewModelFactory(
    private val repository: FilmRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SimilarFilmsViewModel::class.java)) {
            return SimilarFilmsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}