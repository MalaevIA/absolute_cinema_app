package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenFavorites

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.RegisterRetrfit.AuthApiClient
import com.example.absolute_cinema_app.domain.RegisterRetrfit.TokenManager
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories.ScreenCategory.FilmRow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFavorites(navController: NavController) {
    val context = LocalContext.current
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val backgroundColor: Color = MaterialTheme.colorScheme.background

    val favoriteFilms = remember { mutableStateListOf<Film>() }

    val isLoading = remember { mutableStateOf(true) }

    val filmApi = remember {
        Retrofit.Builder()
            .baseUrl("https://kinopoiskapiunofficial.tech/")
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmAPI::class.java)
    }

    LaunchedEffect(Unit) {
        try {
            val token = TokenManager.getToken(context)
            val favoritesResponse = AuthApiClient.authApi.getFavorites("Bearer $token")
            val ids = favoritesResponse.body()?.favorites ?: emptyList()
            val films = ids.mapNotNull {
                try {
                    filmApi.getFilmById(it.toInt())
                } catch (_: Exception) { null }
            }
            favoriteFilms.clear()
            favoriteFilms.addAll(films)
        } catch (e: Exception) {
            Log.e("FavoritesScreen", "Ошибка: ${e.message}")
        } finally {
            isLoading.value = false
        }
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(
            title = { Text(text = "Закладки", fontWeight = FontWeight.Bold) },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "фильтры"
                    )
                }
            }
        ) }
    ) { paddingValues ->
        if (isLoading.value) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                if (favoriteFilms.isEmpty()) {
                    item {
                        Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(paddingValues).fillMaxSize()){
                        Column (modifier = Modifier.padding(bottom = 100.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(R.drawable.snapedit_png),
                                contentDescription = "",
                                modifier = Modifier.width(screenWidth / 2)
                                    .height(screenWidth / 2)
                            )
                            Text(
                                "Список закладок пока пуст",
                                textAlign = TextAlign.Center
                            )
                        }
                        }
                    }
                } else {
                    items(favoriteFilms) { film ->
                        FavoritesFilmRow(film, screenWidth, navController, onDelete = { filmToRemove -> favoriteFilms.remove(filmToRemove)})
                    }
                }
            }
        }
    }
}
