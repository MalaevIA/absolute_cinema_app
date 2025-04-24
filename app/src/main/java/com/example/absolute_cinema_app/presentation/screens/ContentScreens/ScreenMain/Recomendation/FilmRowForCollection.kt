package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.Recomendation

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
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmCollectionResponse_item

@Composable
fun FilmRowForCollection(film: FilmCollectionResponse_item, screenWidth: Dp, navController: NavController) {
    Row (modifier = Modifier.height(screenWidth/2)
        .fillMaxWidth()
        .padding(top = 8.dp)
        .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
        .clickable { navController.navigate("ScreenFilm/${film.kinopoiskId}") }){
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
            val name = if(film.nameOriginal == null){if(film.nameRu== null){film.nameEn}else{film.nameRu}} else{film.nameOriginal}
            Text(text = "Название: ${name}", fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "Жанр: ${film.genres.joinToString { it.genre }}", color = Color.White)
        }
    }
}