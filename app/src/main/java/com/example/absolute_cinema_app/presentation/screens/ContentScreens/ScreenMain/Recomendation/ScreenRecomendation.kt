package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.Recomendation

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmCollectionResponse_item
import com.example.absolute_cinema_app.domain.FilmsRetrofit.PremiereResponseItem
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRecomendation(Recomendation:String, navController: NavController){
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val monthIndex = calendar.get(Calendar.MONTH)

    val month = when (monthIndex) {
        0 -> "JANUARY"
        1 -> "FEBRUARY"
        2 -> "MARCH"
        3 -> "APRIL"
        4 -> "MAY"
        5 -> "JUNE"
        6 -> "JULY"
        7 -> "AUGUST"
        8 -> "SEPTEMBER"
        9 -> "OCTOBER"
        10 -> "NOVEMBER"
        11 -> "DECEMBER"
        else -> "JANUARY"
    }
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)
    val filmStateForNew = remember { mutableStateOf<List<PremiereResponseItem>>(emptyList()) }
    val filmStateNeedToWatch = remember { mutableStateOf<List<FilmCollectionResponse_item>>(emptyList()) }
    when(Recomendation){
        "Новинки" ->
            LaunchedEffect(Unit) {
                try {
                    val film = filmApi.getPremieres(year, month)
                    filmStateForNew.value = film.items
                } catch (e: Exception) {
                    Log.e("Server", "Ошибка: ${e.message}")
                }
            }

        "Смотрите" ->
            LaunchedEffect(Unit) {
                try {
                    val film = filmApi.getTopPopularFilms(type = "TOP_POPULAR_ALL", page = 1)
                    filmStateNeedToWatch.value = film.items
                } catch (e: Exception) {
                    Log.e("Server", "Ошибка: ${e.message}")
                }
            }

    }
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(title = { Text(text = Recomendation, fontWeight = FontWeight.Bold) }) }
    ){paddingValues ->
        if(Recomendation.equals("Новинки")){
            val filmState = filmStateForNew
            ContentOfPremiereRecomendation(filmState, screenWidth, navController, paddingValues)

        }
        else if(Recomendation.equals("Смотрите")){
            val filmState = filmStateNeedToWatch
            ContentOfCollectionRecomendation(filmState, screenWidth, navController, paddingValues)
        }
    }


}
@Composable
fun ContentOfCollectionRecomendation(filmState: MutableState<List<FilmCollectionResponse_item>>, screenWidth: Dp, navController: NavController, paddingValues: PaddingValues){
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
    ){
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
                FilmRowForCollection(film, screenWidth, navController)
            }
        }
    }

}

@Composable
fun ContentOfPremiereRecomendation(filmState: MutableState<List<PremiereResponseItem>>, screenWidth: Dp, navController: NavController, paddingValues: PaddingValues){
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
    ){
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
                FilmRowForCollection(film, screenWidth, navController)
            }
        }
    }

}