package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmForSimilars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun SimilarFilms(id:Int, navController: NavController){
    val filmState = remember { mutableStateOf<List<FilmForSimilars>>(emptyList()) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val filmApi = retrofitInstance.create(FilmAPI::class.java)

    LaunchedEffect(id) {
        try {
            val film = filmApi.getSimilarsFilmsById(id)
            Log.d("API Response", "Response: $film")
            filmState.value = film.items
        } catch (e: Exception) {
            Log.e("Server", "${e.message}")
        }
    }
    if (filmState.value.isNotEmpty()) {
        Column {
            Text(
                text = "Вам понравится",
                modifier = Modifier.padding(all = 10.dp),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            filmState.value.chunked(2).forEach { filmChunk ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    filmChunk.forEach { film ->
                        SimilarFilmItem(film, navController)
                    }
                }
            }
        }
    }

}
@Composable
fun SimilarFilmItem(film: FilmForSimilars, navController: NavController) {
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp

    Column (
        modifier = Modifier
            .width((screenWidth / 2))
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
            .clickable {navController.navigate("ScreenFilm/${film.filmId}")}
            .padding(8.dp)
    ) {

        Image(
            painter = rememberAsyncImagePainter(film.posterUrlPreview),
            contentDescription = "Постер ${film.nameRu}",
            modifier = Modifier
                .fillMaxWidth()
                .height((screenWidth / 3 * 2))
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = film.nameRu ?: "Нет названия",
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}