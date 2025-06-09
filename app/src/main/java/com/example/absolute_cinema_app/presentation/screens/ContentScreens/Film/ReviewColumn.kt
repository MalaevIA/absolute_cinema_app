package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.absolute_cinema_app.data.models.filmsModels.Review
import com.example.absolute_cinema_app.domain.repos.FilmRepository
import com.example.absolute_cinema_app.domain.FilmsRetrofit.RetrofitFilmInstance
import com.example.absolute_cinema_app.domain.viewModels.ReviewViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.absolute_cinema_app.domain.viewModels.ReviewViewModelFactory
@Composable
fun ReviewColumn(filmId:Int){
    val repository = remember { FilmRepository(RetrofitFilmInstance.api) }
    val factory = remember { ReviewViewModelFactory(repository) }
    val viewModel: ReviewViewModel = viewModel(factory = factory)

    val reviews by viewModel.reviews

    LaunchedEffect(filmId) {
        viewModel.loadReviews(filmId)
    }

    if (reviews.isNotEmpty()) {
        Column(Modifier.padding(16.dp)) {
            Text("Отзывы:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            reviews.forEach { review -> ReviewItem(review) }
        }
    }
}

@Composable
fun ReviewItem(review: Review) {
    // Отображаем каждый отзыв
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        if (review.title != null){
            Text(
                text = review.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (review.author!= null){
            Text(
                text = "Автор: ${review.author}",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )
        }
        if ((review.positiveRating!= null)and(review.negativeRating!= null)){
            Text(
                text = "Положительные: ${review.positiveRating}, Отрицательные: ${review.negativeRating}",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )
        }
        if(review.description!= null){
            Text(
                text = review.description,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

    }
}