package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories.ScreenCategory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.data.models.filmsModels.Film
import com.example.absolute_cinema_app.domain.viewModels.ContinueFilmsViewModel

@Composable
fun FilmRow(film: Film, screenWidth: Dp, navController: NavController,
            viewModel: ContinueFilmsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ContinueFilmsViewModel.factory)) {
    val name = if(film.nameOriginal == null){if(film.nameRu== null){film.nameEn}else{film.nameRu}} else{film.nameOriginal}
    val genre = film.genres.joinToString { it.genre }
    Row (modifier = Modifier.height(screenWidth/2)
        .fillMaxWidth()
        .padding(top = 8.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
        .clickable { navController.navigate("ScreenFilm/${film.kinopoiskId}")
        viewModel.insertFilm(film.kinopoiskId,film.posterUrl,genre, name)}){
        Image(
            painter =  rememberAsyncImagePainter(film.posterUrl),
            contentDescription = "Постер фильма",
            modifier = Modifier
                .width((screenWidth/3))
                .height(screenWidth/2)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop

        )
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Название: ${name}", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
            Text(text = "Жанр: ${film.genres.joinToString { it.genre }}", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}