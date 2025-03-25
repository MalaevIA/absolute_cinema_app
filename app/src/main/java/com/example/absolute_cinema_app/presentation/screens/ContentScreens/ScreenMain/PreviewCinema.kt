package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.absolute_cinema_app.domain.FilmsData.ConstansOfFilms

@Composable
fun PreviewCinema(screenWidth: Dp, imageAlpha: Float, backgroundColor: Color){
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
    LazyRow(
        state = listState,
        flingBehavior = flingBehavior,
        modifier = Modifier
            .height(300.dp)
            .zIndex(1f)

    ) {
        itemsIndexed(ConstansOfFilms.FilmItems) { _, item ->
            Box(
                modifier = Modifier
                    .width(screenWidth)
                    .height(300.dp)
            ) {
                Text(
                    text = item.label,
                    color = Color(0xFFFFEB3B),
                    modifier = Modifier
                        .zIndex(3f)
                        .fillMaxWidth()
                        .padding(top = 235.dp)
                        .graphicsLayer { alpha = imageAlpha },
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
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
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .zIndex(2f)
                ) {
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
}
