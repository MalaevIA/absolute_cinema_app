package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.domain.viewModels.ContinueFilmsViewModel

@Composable
fun ContinueView(navController: NavController
                 , viewModel: ContinueFilmsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ContinueFilmsViewModel.factory)
    ) {
    val filmList = viewModel.filmList.collectAsState(emptyList())
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Продолжить просмотр",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(
                onClick = {
                    navController.navigate("ScreenContinueWatch")
                },

                modifier = Modifier.clip(RoundedCornerShape(50.dp))
                    .background(Color.DarkGray)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .size(40.dp),

                ) {
                Icon(

                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "продолжить просмотр"
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .height(270.dp)

        ) {
            if(filmList.value.isNullOrEmpty()){
                item {
                    Box(modifier = Modifier.fillParentMaxSize(),
                        contentAlignment = Alignment.Center){
                        Text(
                            "Вы не начинали ничего смотреть",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            else{
                items(filmList.value.take(5)) {film ->
                    Column(modifier = Modifier.clickable { navController.navigate("ScreenFilm/${film.id}")
                        viewModel.insertFilm(film.id,film.poster,film.genre,film.label)}, verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(film.poster),
                            contentDescription = "",
                            modifier = Modifier.height(180.dp)
                                .width(300.dp)
                                .padding(10.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            film.label!!,
                            modifier = Modifier.padding(start = 15.dp)
                                .width(200.dp)
                                .clipToBounds(),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            film.genre?.split(",")?.first() ?: "Нет жанров",
                            modifier = Modifier.padding(start = 15.dp),
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                        Icon(
                            modifier = Modifier.padding(top = 210.dp, start = 190.dp),
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "продолжить просмотр",


                            )
//                    Text(
//                        item.days_from_the_beginning_of_viewing.toString() + " дн. назад",
//                        modifier = Modifier.padding(top = 210.dp, start = 215.dp),
//                        fontSize = 12.sp,
//                        color = Color.DarkGray
//                    )
                    }

                }
            }

        }
    }
}