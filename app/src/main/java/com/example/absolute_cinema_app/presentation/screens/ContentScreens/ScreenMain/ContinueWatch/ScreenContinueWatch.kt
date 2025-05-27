package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.domain.viewModels.ContinueFilmsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContinueWatch(navController: NavController,viewModel: ContinueFilmsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ContinueFilmsViewModel.factory)){

    val filmList = viewModel.filmList.collectAsState(emptyList())
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Продолжить просмотр", fontWeight = FontWeight.Bold) },
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Назад"
                    )
                }
            }) }
    ){paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ){
            items(filmList.value) { film ->
                FilmRowForContinueWatch(film, screenWidth, navController)
            }
        }
    }
}