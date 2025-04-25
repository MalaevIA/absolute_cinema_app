package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.absolute_cinema_app.domain.room.App
import com.example.absolute_cinema_app.domain.room.ContinueFilmsDB
import com.example.absolute_cinema_app.domain.room.FilmEntity
import kotlinx.coroutines.launch


class ContinueFilmsViewModel(val database: ContinueFilmsDB):ViewModel() {

    val filmList = database.dao.getAllFilms()


    fun insertFilm(id:Int,
                   poster:String?,
                   genre: String?,
                   label:String?,) = viewModelScope.launch {
        val filmItem = FilmEntity(id,poster,genre,label)
        database.dao.insertFilm(filmItem)
    }

    companion object{
        @Suppress("UNCHECKED_CAST")
        val factory: ViewModelProvider.Factory = object :ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return ContinueFilmsViewModel(database) as T
            }
        }
    }
}