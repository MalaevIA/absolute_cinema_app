package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar
import com.example.absolute_cinema_app.domain.FilmsRetrofit.Film


@Composable
fun ScreenMain(
    navController: NavController
) {
    var searchQuery by remember { mutableStateOf("") }
    val filmState = remember { mutableStateOf<List<Film>>(emptyList()) }
    val handleSearchResults: (List<Film>) -> Unit = { films ->
        filmState.value = films
    }

    val scrollState: ScrollState = rememberScrollState()
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val imageAlpha: Float = 1f - (scrollState.value / 500f).coerceIn(0f, 1f)
    val backgroundColor: Color = MaterialTheme.colorScheme.background

    Scaffold(
        Modifier.background(MaterialTheme.colorScheme.background),
        bottomBar = { BottomNavigationBar(navController) },

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(bottom = paddingValues.calculateBottomPadding()) // Отступ под BottomNav
        ) {
            PreviewCinema(screenWidth, imageAlpha, backgroundColor, navController)

            OnSearchScreen(
                navController
            )

            ContinueView(navController)

            NewView(navController)

            NeedToWatchView(navController)
        }
    }
}





