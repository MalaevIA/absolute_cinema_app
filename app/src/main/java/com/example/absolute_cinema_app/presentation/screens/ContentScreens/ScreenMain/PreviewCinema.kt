package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmCollectionResponse_item
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun PreviewCinema(screenWidth: Dp, imageAlpha: Float, backgroundColor: Color, navController: NavController){
    val filmState = remember { mutableStateOf<List<FilmCollectionResponse_item>>(emptyList()) }

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
            val film = filmApi.getTopPopularFilms(type = "OSKAR_WINNERS_2021", page = 1)
            filmState.value = film.items
        } catch (e: Exception) {
            Log.e("Server", "Ошибка: ${e.message}")
        }
    }

    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    LazyRow(
        state = listState,
        flingBehavior = flingBehavior,
        modifier = Modifier
            .height(screenWidth*4/3)
            .zIndex(1f)

    ) {
        items(filmState.value) {film ->
            Box(
                modifier = Modifier
                    .width(screenWidth)
                    .height(screenWidth*4/3)
                    .clickable { navController.navigate("ScreenFilm/${film.kinopoiskId}")}
            ) {
                Text(
                    text = if(film.nameOriginal == null){if(film.nameRu== null){film.nameEn!!}else{film.nameRu}} else{film.nameOriginal},
                    color = Color(0xFFFFEB3B),
                    modifier = Modifier
                        .zIndex(3f)
                        .fillMaxWidth()
                        .padding(top = screenWidth*4/3 - 50.dp)
                        .graphicsLayer { alpha = imageAlpha },
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Image(
                    painter = rememberAsyncImagePainter(film.posterUrl),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenWidth*4/3)
                        .graphicsLayer { alpha = imageAlpha }
                        .zIndex(1f),
                    contentScale = ContentScale.Crop
                )
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenWidth*4/3)
                        .zIndex(2f)
                ) {
                    val gradientBrush = Brush.verticalGradient(
                        colors = listOf(backgroundColor, Color.Transparent),
                        startY = size.height,
                        endY = size.height - 300f
                    )
                    drawRect(
                        brush = gradientBrush,
                        size = Size(size.width, size.height)
                    )
                }
            }
        }
    }
}
