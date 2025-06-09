package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.content.res.Configuration
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.domain.FilmsRetrofit.RetrofitFilmInstance
import com.example.absolute_cinema_app.data.models.filmsModels.FilmForSimilars
import com.example.absolute_cinema_app.domain.repos.FilmRepository
import com.example.absolute_cinema_app.domain.viewModels.SimilarFilmsViewModel
import com.example.absolute_cinema_app.domain.viewModels.SimilarFilmsViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SimilarFilms(id:Int, navController: NavController){
    val repository = remember { FilmRepository(RetrofitFilmInstance.api) }
    val factory = remember { SimilarFilmsViewModelFactory(repository) }
    val viewModel: SimilarFilmsViewModel = viewModel(factory = factory)

    val filmState by viewModel.similarFilms

    LaunchedEffect(id) {
        viewModel.loadSimilarFilms(id)
    }

    if (filmState.isNotEmpty()) {
        Column {
            Text(
                text = "Вам понравится",
                modifier = Modifier.padding(all = 10.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            filmState.chunked(2).forEach { filmChunk ->
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
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}