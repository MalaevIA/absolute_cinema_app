package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.data.models.filmsModels.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.RegisterRetrfit.AuthApiClient
import com.example.absolute_cinema_app.domain.viewModels.AuthViewModel
import com.example.absolute_cinema_app.data.models.authModels.FavoriteRequest
import com.example.absolute_cinema_app.data.Tokens.TokenManager
import com.example.absolute_cinema_app.data.models.filmsModels.VideoItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ScreenFilm( kinopoiskId:Int, navController: NavController){//написать проверку для фильма есть ли он в избранном при открытии карточки
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val backgroundColor: Color = MaterialTheme.colorScheme.background
    val filmState = remember { mutableStateOf<Film?>(null) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val context = LocalContext.current
    val authViewModel: AuthViewModel = viewModel()
    val isAuthorized by authViewModel.isAuthorized

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)
    LaunchedEffect(kinopoiskId) {
        try {
            val film = withContext(Dispatchers.IO) { filmApi.getFilmById(kinopoiskId) }
            filmState.value = film
        } catch (e: Exception) {
            Log.e("Server", "Ошибка загрузки фильма: ${e.message}")
        }
    }
    val videoList = remember { mutableStateOf<List<VideoItem>>(emptyList()) }

    LaunchedEffect(kinopoiskId) {
        try {
            val film = withContext(Dispatchers.IO) { filmApi.getFilmById(kinopoiskId) }
            filmState.value = film

            val videos = withContext(Dispatchers.IO) { filmApi.getVideoForFilmById(kinopoiskId) }
            videoList.value = videos.items
        } catch (e: Exception) {
            Log.e("Server", "Ошибка загрузки: ${e.message}")
        }
    }


    val scrollState = rememberScrollState()
    filmState.value?.let { film ->
        Column(modifier = Modifier.fillMaxSize()
            .verticalScroll(scrollState)
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
                        .fillMaxWidth()
                        .height(screenWidth / 2 * 3)
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            }
            val name = if(film.nameOriginal == null){if(film.nameRu== null){film.nameEn}else{film.nameRu}} else{film.nameOriginal}
            Row{
                Column (modifier = Modifier.width(screenWidth/3*2)){
                    Text(text = name,
                        modifier = Modifier.padding(all = 10.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Жанры: "+filmState.value!!.genres.joinToString(separator = ", ") { it.genre },
                        modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 15.sp,)
                }
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(Color.DarkGray)
                        .clickable(enabled = isAuthorized) {
                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    val token_ = TokenManager.getToken(context)
                                    val token = "Bearer $token_"
                                    val response = AuthApiClient.authApi.addToFavorites(
                                        token,
                                        FavoriteRequest(kinopoiskId.toString())
                                    )
                                    withContext(Dispatchers.Main) {
                                        if (response.isSuccessful) {
                                            Toast.makeText(context, "Добавлено в избранное", Toast.LENGTH_SHORT).show()
                                        } else {
                                            Toast.makeText(context, "Ошибка: ${response.code()}", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                } catch (e: Exception) {
                                    withContext(Dispatchers.Main) {
                                        Toast.makeText(context, "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                        .then(if (!isAuthorized) Modifier.alpha(0.5f) else Modifier),
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
                        modifier = Modifier.fillMaxSize(0.7f),
                    )
                }


            }
            if(filmState.value!!.description!=null){
                Text(text = "Описание",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = filmState.value!!.description,
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,)
            }
            if((filmState.value!!.ratingImdb != 0.0f) and (filmState.value!!.ratingKinopoisk != 0.0f)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Imdb: "+filmState.value!!.ratingImdb.toString() + ", Кинопоиск: "+filmState.value!!.ratingKinopoisk,
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,)
            }
            else if((filmState.value!!.ratingImdb != 0.0f) and (filmState.value!!.ratingKinopoisk == 0.0f)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Imdb: "+filmState.value!!.ratingImdb.toString(),
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,)
            }
            else if ((filmState.value!!.ratingImdb == 0.0f) and (filmState.value!!.ratingKinopoisk != 0.0f)){
                Text(text = "Рейтинг",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Кинопоиск: "+filmState.value!!.ratingKinopoisk.toString(),
                    modifier = Modifier.padding(bottom = 8.dp, start = 8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,)
            }
            else{
                Text(text = "Пока нет рейтинга",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (videoList.value.isNotEmpty()) {
                Text(
                    text = "Видео",
                    modifier = Modifier.padding(all = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                videoList.value.forEach { video ->
                    if (video.site.equals("YOUTUBE", ignoreCase = true)) {
                        val videoId = video.url.substringAfterLast("=")
                        val thumbnailUrl = "https://img.youtube.com/vi/$videoId/0.jpg"

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                                    context.startActivity(intent)
                                }
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(thumbnailUrl),
                                contentDescription = video.name,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = video.name,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            SimilarFilms(filmState.value!!.kinopoiskId, navController)
            ReviewColumn(filmState.value!!.kinopoiskId)
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