package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.CategoryData.ConstansOfCategory

@Composable
fun FirstCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {

    Row(modifier = Modifier.height(screenWidth/2).fillMaxWidth()) {
        Box(modifier = Modifier.padding(start = 8.dp).width((screenWidth/5)*2)) {
            val label = ConstansOfCategory.CategoryItems[0].label
            val IdIcon = ConstansOfCategory.CategoryItems[0].icon
            Image(
                painter = painterResource(id = IdIcon),
                contentDescription = "",
                modifier = Modifier.matchParentSize()
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { navController.navigate("ScreenCategory/$label") },
                contentScale = ContentScale.Crop
            )
            Canvas(modifier = Modifier.matchParentSize()) {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(backgroundColor, Color.Transparent),
                        startY = size.height,
                        endY = size.height - 150f
                    ),
                    size = size
                )
            }
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier

                    .padding(top = screenWidth/2 - 30.dp, start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        }
        Box(modifier = Modifier.padding(start = 8.dp)) {
            LazyColumn(userScrollEnabled = false) {
                itemsIndexed(ConstansOfCategory.CategoryItems.slice(1..2)) { _, item ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp, end = 8.dp)
                            .width((screenWidth/5)*3)
                            .clip(RoundedCornerShape(20.dp)),
                    ) {
                        val label = item.label
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            modifier = Modifier.height(screenWidth/4 -4.dp)
                                .clickable { navController.navigate("ScreenCategory/$label") },
                            contentScale = ContentScale.Crop

                        )
                        Canvas(modifier = Modifier.matchParentSize()) {
                            drawRect(
                                brush = Brush.verticalGradient(
                                    colors = listOf(backgroundColor, Color.Transparent),
                                    startY = size.height,
                                    endY = size.height - 150f
                                ),
                                size = size
                            )
                        }
                        Text(
                            text = item.label,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .padding(top = screenWidth/4 -30.dp, start = 8.dp).fillMaxHeight(),
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SecondCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()
            .height(screenWidth / 2 - 18.dp),
        userScrollEnabled = false
    ) {
        itemsIndexed(ConstansOfCategory.CategoryItems.slice(3..4)) { _, item ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(screenWidth / 2 - 12.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(20.dp))
            ) {
                val label = item.label
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize()
                        .clickable { navController.navigate("ScreenCategory/$label") },
                    contentScale = ContentScale.Crop
                )
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(backgroundColor, Color.Transparent),
                            startY = size.height,
                            endY = size.height - 150f
                        ),
                        size = size
                    )
                }
                Text(
                    text = item.label,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = screenWidth / 2 - 48.dp, start = 8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
        }
    }
}


@Composable
fun ThirdCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {
    Row(
        modifier = Modifier.height(screenWidth/2).fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
            LazyColumn(userScrollEnabled = false) {
                itemsIndexed(ConstansOfCategory.CategoryItems.slice(5..6)) { _, item ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .clickable {  }
                            .width((screenWidth/5)*3)
                            .height(screenWidth/4 - 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        val label = item.label
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            modifier = Modifier.matchParentSize()
                                .clickable { navController.navigate("ScreenCategory/$label") },
                            contentScale = ContentScale.Crop,
                        )
                        Canvas(modifier = Modifier.matchParentSize()) {
                            drawRect(
                                brush = Brush.verticalGradient(
                                    colors = listOf(backgroundColor, Color.Transparent),
                                    startY = size.height,
                                    endY = size.height - 150f
                                ),
                                size = size
                            )
                        }
                        Text(
                            text = item.label,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.matchParentSize()
                                .padding(top = screenWidth/4 - 34.dp, start = 8.dp),
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .width((screenWidth/5)*2)
                .clip(RoundedCornerShape(20.dp))
        ) {
            val label = ConstansOfCategory.CategoryItems[7].label
            Image(
                painter = painterResource(id = ConstansOfCategory.CategoryItems[7].icon),
                contentDescription = "",
                modifier = Modifier.matchParentSize()
                    .clickable { navController.navigate("ScreenCategory/$label") },
                contentScale = ContentScale.Crop
            )
            Canvas(modifier = Modifier.matchParentSize()) {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(backgroundColor, Color.Transparent),
                        startY = size.height,
                        endY = size.height - 150f
                    ),
                    size = size
                )
            }
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(top = screenWidth/2 - 30.dp, start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun FourthCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()
            .height(screenWidth / 2 - 18.dp),
        userScrollEnabled = false
    ) {
        itemsIndexed(ConstansOfCategory.CategoryItems.slice(8..9)) { _, item ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(screenWidth / 2 - 12.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(20.dp))
            ) {
                val label = item.label
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize()
                        .clickable { navController.navigate("ScreenCategory/$label") },
                    contentScale = ContentScale.Crop
                )
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(backgroundColor, Color.Transparent),
                            startY = size.height,
                            endY = size.height - 150f
                        ),
                        size = size
                    )
                }
                Text(
                    text = item.label,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = screenWidth / 2 - 48.dp, start = 8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun FifthCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {
    LazyRow(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth()
            .height(screenWidth / 3 - 16.dp),
        userScrollEnabled = false
    ) {
        itemsIndexed(ConstansOfCategory.CategoryItems.slice(10..12)) { _, item ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(screenWidth / 3 - 10.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(20.dp))
            ) {
                val label = item.label
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize()
                        .clickable { navController.navigate("ScreenCategory/$label") },
                    contentScale = ContentScale.Crop
                )
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(backgroundColor, Color.Transparent),
                            startY = size.height,
                            endY = size.height - 150f
                        ),
                        size = size
                    )
                }
                Text(
                    text = item.label,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .width(screenWidth / 3 - 10.dp)
                        .padding(top = screenWidth / 3 - 46.dp, start = 8.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun SixthCategoryRow(screenWidth: Dp, backgroundColor: Color, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(screenWidth/2)
            .clip(RoundedCornerShape(20.dp))
    ) {
        val label = ConstansOfCategory.CategoryItems[13].label
        Image(
            painter = painterResource(id = ConstansOfCategory.CategoryItems[13].icon),
            contentDescription = "",
            modifier = Modifier.matchParentSize()
                .clickable { navController.navigate("ScreenCategory/$label") },
            contentScale = ContentScale.Crop
        )
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(backgroundColor, Color.Transparent),
                    startY = size.height,
                    endY = size.height - 150f
                ),
                size = size
            )
        }
        Text(
            text = ConstansOfCategory.CategoryItems[13].label,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = screenWidth/2 - 30.dp, start = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 15.sp
        )

    }
}