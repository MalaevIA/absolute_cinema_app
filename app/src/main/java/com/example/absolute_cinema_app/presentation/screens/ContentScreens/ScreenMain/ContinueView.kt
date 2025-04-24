package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.FilmsData.ConstansOfFilms
import com.example.absolute_cinema_app.R

@Composable
fun ContinueView(navController: NavController){
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween ) {
            Text(
                "Продолжить просмотр",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {

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
        LazyRow (modifier = Modifier
            .height(230.dp)) {
            itemsIndexed(ConstansOfFilms.FilmItems.slice(0..2)) { _, item ->
                Box(){
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        modifier = Modifier.height(180.dp)
                            .width(300.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text (
                        item.label,
                        modifier = Modifier.padding(top = 185.dp, start = 15.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        item.genre,
                        modifier = Modifier.padding(top = 210.dp, start = 15.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                    Icon(
                        modifier = Modifier.padding(top = 210.dp, start = 190.dp),
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "продолжить просмотр",


                        )
                    Text(
                        item.days_from_the_beginning_of_viewing.toString() + " дн. назад",
                        modifier = Modifier.padding(top = 210.dp, start = 215.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                }

            }
        }
    }
}