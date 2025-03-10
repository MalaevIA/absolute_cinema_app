package com.example.absolute_cinema_app.screens
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.absolute_cinema_app.FilmsData.ConstansOfFilms
import com.example.absolute_cinema_app.R

@Composable
fun ScreenMain() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val scrollState = rememberScrollState()
    val imageAlpha = 1f - (scrollState.value / 200f).coerceIn(0f, 1f)
    val backgroundColor = MaterialTheme.colorScheme.background
    Box(modifier = Modifier.fillMaxSize()) {
        LazyRow(modifier = Modifier
            .height(300.dp)
            .zIndex(1f)) {
            itemsIndexed(
                ConstansOfFilms.FilmItems
            ){_,item->
                Box (modifier = Modifier
                    .width(screenWidth)
                    .height(300.dp)){
                    Text(text = item.label,
                        color = Color(0xFFFFEB3B),
                        modifier = Modifier
                            .zIndex(3f)
                            .fillMaxWidth()
                            .padding(top = 235.dp)
                            .graphicsLayer { alpha = imageAlpha },
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp)
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .graphicsLayer { alpha = imageAlpha }
                            .zIndex(1f),
                        contentScale = ContentScale.Crop
                    )
                    Canvas(modifier = Modifier.fillMaxWidth()//градиент
                        .height(300.dp).zIndex(2f)
                        .graphicsLayer { alpha = imageAlpha }) {

                        val gradientBrush = Brush.verticalGradient(
                            colors = listOf(backgroundColor, Color.Transparent),
                            startY = size.height,
                            endY = size.height - 150f
                        )
                        drawRect(
                            brush = gradientBrush,
                            size = Size(size.width, size.height)
                        )
                    }

                }
            }
        }


        Column(modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 300.dp)
            .zIndex(0f)
        ) {

            Text(
                text = "Content here...",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp)
            )
            repeat(20) {
                Text("Item $it", modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}

@Composable
fun ScreenCategories() {}

@Composable
fun ScreenFavorites() {}

@Composable
fun ScreenSettings() {}