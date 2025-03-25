package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.example.absolute_cinema_app.domain.CategoryData.ConstansOfCategory
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCategories(navController: NavController) {
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
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
            FirstCategoryRow(screenWidth, backgroundColor, navController)

            SecondCategoryRow(screenWidth, backgroundColor, navController)

            ThirdCategoryRow(screenWidth, backgroundColor, navController)

            FourthCategoryRow(screenWidth, backgroundColor, navController)

            FifthCategoryRow(screenWidth, backgroundColor, navController)

            SixthCategoryRow(screenWidth, backgroundColor, navController)
        }
    }
}


