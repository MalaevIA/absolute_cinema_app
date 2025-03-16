package com.example.absolute_cinema_app.screens.ContentScreens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFavorites(navController: NavController) {
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val backgroundColor: Color = MaterialTheme.colorScheme.background
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = { TopAppBar(
            title = { Text(text = "Закладки", fontWeight = FontWeight.Bold) },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "фильтры"
                    )
                }
            }
        ) }
    ) { paddingValues ->
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.padding(paddingValues).fillMaxSize()){
            Column (modifier = Modifier.padding(bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(R.drawable.snapedit_png),
                    contentDescription = "",
                    modifier = Modifier.width(screenWidth/2)
                        .height(screenWidth/2)
                )
                Text("Список закладок пока пуст",
                    textAlign = TextAlign.Center)
            }
        }
    }
}
