package com.example.absolute_cinema_app.screens.ContentScreens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.retroifit.Film
import com.example.absolute_cinema_app.retroifit.FilmAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCategory(Genre:String, navController: NavController){

    val filmState = remember { mutableStateOf<Film?>(null) }
    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)
    val composableScope = rememberCoroutineScope()
    composableScope.launch {
        try{
            val film = filmApi.getFilmById(301)
            filmState.value = film
        } catch (e: Exception){
            Log.e("Server","${e.message}")
        }
    }
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(title = { Text(text = Genre, fontWeight = FontWeight.Bold) }) }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding()))

                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            if (filmState.value == null) {
                Text(text = "Загрузка...")
            } else {
                val film = filmState.value

                Text(text = filmState.toString())

            }
        }
    }
}