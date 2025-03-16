package com.example.absolute_cinema_app.screens.ContentScreens

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.CategoryData.ConstansOfCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCategories(navController: NavController) {
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val screenHeight : Dp = configuration.screenHeightDp.dp
    val backgroundColor: Color = MaterialTheme.colorScheme.background
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(title = { Text(text = "Категории", fontWeight = FontWeight.Bold) }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PaddingValues(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding()))

                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FirstCategoryRow(screenWidth, backgroundColor)

            SecondCategoryRow(screenWidth, backgroundColor)

            ThirdCategoryRow(screenWidth, backgroundColor)

            FourthCategoryRow(screenWidth, backgroundColor)

            FifthCategoryRow(screenWidth, backgroundColor)

            SixthCategoryRow(screenWidth, backgroundColor)
        }
    }
}


@Composable
fun FirstCategoryRow(screenWidth: Dp, backgroundColor: Color) {
    Row(modifier = Modifier.height(screenWidth/2).fillMaxWidth()) {
        Box(modifier = Modifier.padding(start = 8.dp).width((screenWidth/5)*2)) {
            Image(
                painter = painterResource(id = ConstansOfCategory.CategoryItems[0].icon),
                contentDescription = "",
                modifier = Modifier.matchParentSize()
                    .clip(RoundedCornerShape(20.dp)),
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
                text = ConstansOfCategory.CategoryItems[0].label,
                color = Color.White,
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
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            modifier = Modifier.height(screenWidth/4 -4.dp),
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
                            color = Color.White,
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
fun SecondCategoryRow(screenWidth: Dp, backgroundColor: Color) {
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
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize(),
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
                    color = Color.White,
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
fun ThirdCategoryRow(screenWidth: Dp, backgroundColor: Color) {
    Row(
        modifier = Modifier.height(screenWidth/2).fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
            LazyColumn(userScrollEnabled = false) {
                itemsIndexed(ConstansOfCategory.CategoryItems.slice(5..6)) { _, item ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width((screenWidth/5)*3)
                            .height(screenWidth/4 - 4.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            modifier = Modifier.matchParentSize(),
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
                            color = Color.White,
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
            Image(
                painter = painterResource(id = ConstansOfCategory.CategoryItems[7].icon),
                contentDescription = "",
                modifier = Modifier.matchParentSize(),
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
                text = ConstansOfCategory.CategoryItems[7].label,
                color = Color.White,
                modifier = Modifier
                    .padding(top = screenWidth/2 - 30.dp, start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun FourthCategoryRow(screenWidth: Dp, backgroundColor: Color) {
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
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize(),
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
                    color = Color.White,
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
fun FifthCategoryRow(screenWidth: Dp, backgroundColor: Color) {
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
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "",
                    modifier = Modifier.matchParentSize(),
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
                    color = Color.White,
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
fun SixthCategoryRow(screenWidth: Dp,backgroundColor: Color) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(screenWidth/2)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painterResource(id = ConstansOfCategory.CategoryItems[13].icon),
            contentDescription = "",
            modifier = Modifier.matchParentSize(),
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