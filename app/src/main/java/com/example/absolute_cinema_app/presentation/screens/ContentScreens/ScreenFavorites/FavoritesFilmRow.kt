package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenFavorites

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.data.models.filmsModels.Film
import com.example.absolute_cinema_app.domain.RegisterRetrfit.AuthApiClient
import com.example.absolute_cinema_app.data.models.authModels.FavoriteRequest
import com.example.absolute_cinema_app.data.Tokens.TokenManager
import com.example.absolute_cinema_app.domain.viewModels.ContinueFilmsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun FavoritesFilmRow(
    film: Film,
    screenWidth: Dp,//написать проверку для фильма есть ли он в избранном при открытии карточки
    navController: NavController,
    onDelete: (Film) -> Unit,
    viewModel: ContinueFilmsViewModel = viewModel(factory = ContinueFilmsViewModel.factory)
) {
    val name = film.nameOriginal ?: film.nameRu ?: film.nameEn ?: "Без названия"
    val genre = film.genres.joinToString { it.genre }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .height(screenWidth / 2)
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
            .clickable {
                navController.navigate("ScreenFilm/${film.kinopoiskId}")
                viewModel.insertFilm(film.kinopoiskId, film.posterUrl, genre, name)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(film.posterUrl),
                contentDescription = "Постер фильма",
                modifier = Modifier
                    .width(screenWidth / 3)
                    .height(screenWidth / 2)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Название: $name",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Жанр: $genre",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            IconButton(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val token_ = TokenManager.getToken(context)
                            val token = "Bearer $token_"
                            val response = AuthApiClient.authApi.removeFromFavorites(
                                FavoriteRequest(film.kinopoiskId.toString()),
                                token
                            )
                            withContext(Dispatchers.Main) {
                                if (response.isSuccessful) {
                                    onDelete(film)
                                    Toast.makeText(
                                        context,
                                        "Удалено из избранного",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Ошибка удаления: ${response.code()}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "Ошибка: ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                },
                modifier = Modifier.align(Alignment.Top)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Удалить из избранного",
                    tint = Color.Red
                )
            }
        }

    }
}

//first@user.com