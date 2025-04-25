package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.domain.FilmsData.ConstansOfFilms
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmCollectionResponse
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmCollectionResponse_item
import com.example.absolute_cinema_app.domain.FilmsRetrofit.PremiereResponseItem
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch.ContinueFilmsViewModel
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar

@Composable
fun NewView(navController: NavController,
            viewModel: ContinueFilmsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ContinueFilmsViewModel.factory)){

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

    val filmState = remember { mutableStateOf<List<PremiereResponseItem>>(emptyList()) }

    val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)

    LaunchedEffect(Unit) {
        try {
            val film = filmApi.getPremieres(year, month)
            filmState.value = film.items
        } catch (e: Exception) {
            Log.e("Server", "Ошибка: ${e.message}")
        }
    }
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween ) {
            Text(
                "Новинки",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {
                navController.navigate("ScreenRecomendation/Новинки")
            },
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
                    .background(Color.DarkGray)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .size(40.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "к новинкам"
                )
            }
        }
        LazyRow (modifier = Modifier
            .height(330.dp)) {
            items(filmState.value.take(5)) { film ->
                val name = if(film.nameRu== null){film.nameEn}else{film.nameRu}
                val genre = film.genres.joinToString { it.genre }
                Box(
                    modifier = Modifier.clickable { navController.navigate("ScreenFilm/${film.kinopoiskId}")
                    viewModel.insertFilm(film.kinopoiskId,film.posterUrl,genre,name)}
                ){
                    Image(
                        painter = rememberAsyncImagePainter(film.posterUrl),
                        contentDescription = "",
                        modifier = Modifier.height(250.dp)
                            .width(200.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text (
                            text = if(film.nameRu== null){film.nameEn!!}else{film.nameRu},
                            modifier = Modifier.padding(top = 245.dp, start = 15.dp)
                                .width(200.dp)
                                .clipToBounds(),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(0.dp))
                        Text(
                            text = film.genres?.firstOrNull()?.genre ?: "",
                            modifier = Modifier.padding(start = 15.dp),
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                    }

                }

            }
        }
    }
}