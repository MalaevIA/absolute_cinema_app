package com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Review
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ReviewColumn(id:Int){
    val reviews = remember { mutableStateOf<List<Review>>(emptyList()) }
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
            val response = filmApi.getReviewsToFilmById(id)
            Log.d("API Response", "Response: $response")
            reviews.value =response.items
        } catch (e: Exception) {
            Log.e("Server", "${e.message}")
        }
    }
    // Отображение отзывов, если они есть
    if (reviews.value.isNotEmpty()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Отзывы:",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Проходим по каждому отзыву и отображаем его
            reviews.value.forEach { review ->
                ReviewItem(review) // Вспомогательная функция для отображения отзыва
            }
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