package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategory

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCategory(genre:String, navController: NavController){
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val filmState = remember { mutableStateOf<List<Film>>(emptyList()) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)
    var idGenre: Int? = null
    when(genre){
        "Ток-шоу" -> idGenre = 32
        "Драма" -> idGenre = 2
        "Фантастика" -> idGenre = 6
        "Детектив" -> idGenre = 5
        "Военный" -> idGenre = 14
        "Мультфильм" -> idGenre = 18
        "Приключения" -> idGenre = 7
        "Мелодрама" -> idGenre = 4
        "Документальный" -> idGenre = 22
        "Спорт" -> idGenre = 21
        "Семейный" -> idGenre = 19
        "Боевик" -> idGenre = 11
        "Комедия" -> idGenre = 13
        "Триллер" -> idGenre = 1
    }

    // 1 - Триллер,  2 - драма, 3 - криминал 4 - мелодрама 5 - детектив, 6 - фантастика 7 - приключения 8 - биография 9 - фильм-нуар 10 - вестерн 11 - боевик 12 - фэнтэзи 13 - комедия 14 - военный 32 - ток шоу
    // 15 - история 16 - музыка 17 - ужасы 18 - мультфильм 19 - семейный 20 - мюзикл 21 - спорт 22 - документальный 23 - короткометражка 24 - аниме 25 - ? 26 - новости 27 - концерт 28 - для взрослых 29 - церемония
    // 30 - реальное ТВ 31 - игра 33 - детский

    val composableScope = rememberCoroutineScope()
    composableScope.launch {
        try{
            val film = filmApi.getFilmsByGenre(idGenre!!)
            filmState.value = film.items

        } catch (e: Exception){
            Log.e("Server","${e.message}")
        }
    }
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(title = { Text(text = genre, fontWeight = FontWeight.Bold) }) }
    ){paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        )
        {
            if (filmState.value.isEmpty()) {
                item {
                    Column (modifier = Modifier.fillParentMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        CircularProgressIndicator(
                            modifier = Modifier.size(100.dp),
                            color = Color.DarkGray,
                            strokeWidth = 10.dp
                        )
                    }
                }
            } else {
                items(filmState.value) { film ->
                    FilmRow(film, screenWidth, navController)
                }
            }
        }
    }
}
