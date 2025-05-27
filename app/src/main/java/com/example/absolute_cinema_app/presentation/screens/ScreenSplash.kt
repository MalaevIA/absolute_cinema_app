package com.example.absolute_cinema_app.presentation.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.data.Tokens.TokenManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ScreenSplash(navController: NavController) {
    val context = LocalContext.current

    // Анимация появления (прозрачность и масштаб)
    val alphaAnim = remember { Animatable(0f) }
    val scaleAnim = remember { Animatable(0.8f) }

    LaunchedEffect(Unit) {
        // Анимация запускается
        launch {
            alphaAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 1000)
            )
        }
        launch {
            scaleAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)
            )
        }

        // Задержка для отображения splash
        delay(1500)

        // Логика перехода
        val token = TokenManager.getToken(context)
        if (!token.isNullOrEmpty()) {
            navController.navigate("ScreenMain") {
                popUpTo("ScreenSplash") { inclusive = true }
            }
        } else {
            navController.navigate("ScreenMailAuth") {
                popUpTo("ScreenSplash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF222322))
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(150.dp)
                    .graphicsLayer {
                        alpha = alphaAnim.value
                        scaleX = scaleAnim.value
                        scaleY = scaleAnim.value
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "KinoBaza",
                color = Color(0xFFFFD700),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = alphaAnim.value
                        scaleX = scaleAnim.value
                        scaleY = scaleAnim.value
                    }
            )
        }
    }
}

