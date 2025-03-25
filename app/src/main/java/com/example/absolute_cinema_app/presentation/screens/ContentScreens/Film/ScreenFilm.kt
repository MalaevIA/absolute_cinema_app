package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ScreenFilm( kinopoiskId:Int, navController: NavController){
    val filmState = remember { mutableStateOf<Film?>(null) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)
    val composableScope = rememberCoroutineScope()
    composableScope.launch(Dispatchers.IO) {
        try{
            val film = filmApi.getFilmById(kinopoiskId)
            filmState.value = film

        } catch (e: Exception){
            Log.e("Server","${e.message}")
        }
    }
    Box (modifier = Modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center){
        filmState.value?.let { film ->
            Text(text = "Рейтинг: ${film.ratingKinopoisk}",
                color = Color.White)
        } ?: CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            strokeWidth = 10.dp,
            color = Color.DarkGray

        )

    }
}