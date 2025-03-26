package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ScreenFilm( kinopoiskId:Int, navController: NavController){
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val backgroundColor: Color = MaterialTheme.colorScheme.background

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


    filmState.value?.let { film ->
        Column(modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            Box(Modifier.fillMaxWidth().height(screenWidth / 2 * 3),
                contentAlignment = Alignment.Center){

                Image(
                    modifier = Modifier.matchParentSize(),
                    painter =  rememberAsyncImagePainter(filmState.value!!.posterUrl),
                    contentDescription = "постер",
                    contentScale = ContentScale.Crop
                )
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(backgroundColor, Color.Transparent),
                            startY = size.height,
                            endY = size.height - 500f
                        ),
                        size = size
                    )
                }
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "play Icon",
                        tint = Color.Yellow,
                        modifier = Modifier.fillMaxSize()
                    )
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "play Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
            }
            val name = if(film.nameOriginal == null){if(film.nameRu== null){film.nameEn}else{film.nameRu}} else{film.nameOriginal}
            Row{
                Column (modifier = Modifier.width(screenWidth/3*2)){
                    Text(text = name,
                        modifier = Modifier.padding(all = 10.dp),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Жанры: "+filmState.value!!.genres.joinToString(separator = ", ") { it.genre },
                        modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                        color = Color.LightGray,
                        fontSize = 15.sp,)
                }
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(Color.DarkGray)
                        .clickable {  },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite Icon",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite Icon",
                        tint = Color.DarkGray,
                        modifier = Modifier.fillMaxSize(0.7f)
                    )
                }

            }
            Text(text = "Описание",
                modifier = Modifier.padding(all = 10.dp),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = filmState.value!!.description,
                modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                color = Color.LightGray,
                fontSize = 15.sp,)

            if((filmState.value!!.ratingImdb != null) and (filmState.value!!.ratingKinopoisk != null)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Imdb: "+filmState.value!!.ratingImdb.toString() + ", Кинопоиск: "+filmState.value!!.ratingKinopoisk,
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = Color.LightGray,
                    fontSize = 15.sp,)
            }
            else if((filmState.value!!.ratingImdb != null) and (filmState.value!!.ratingKinopoisk == null)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Imdb: "+filmState.value!!.ratingImdb.toString(),
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = Color.LightGray,
                    fontSize = 15.sp,)
            }
            else if ((filmState.value!!.ratingImdb == null) and (filmState.value!!.ratingKinopoisk != null)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Кинопоиск: "+filmState.value!!.ratingKinopoisk.toString(),
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = Color.LightGray,
                    fontSize = 15.sp,)
            }
            else{
                Text(text = "Пока нет рейтинга",
                    modifier = Modifier.padding(all = 10.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(text = "Вам понравится",
                modifier = Modifier.padding(all = 10.dp),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }
    } ?:
    Box(modifier = Modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            strokeWidth = 10.dp,
            color = Color.DarkGray
        )
    }
}