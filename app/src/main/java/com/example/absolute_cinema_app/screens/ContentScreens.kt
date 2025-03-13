package com.example.absolute_cinema_app.screens
import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.absolute_cinema_app.FilmsData.ConstansOfFilms
import com.example.absolute_cinema_app.FilmsData.ConstantsOfFilms2
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.bottomNavigation.ConstantsOfBottomNav


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = ConstantsOfBottomNav.BottomNavItems
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route


    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Yellow,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Yellow,
                )
            )
        }
    }
}

@Composable
fun ScreenMain(
    navController: NavController
) {
    val scrollState: ScrollState = rememberScrollState()
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val imageAlpha: Float = 1f - (scrollState.value / 500f).coerceIn(0f, 1f)
    val backgroundColor: Color = MaterialTheme.colorScheme.background


    var searchQuery by remember { mutableStateOf("")

    }
    Scaffold(
        Modifier.background(MaterialTheme.colorScheme.background),
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(bottom = paddingValues.calculateBottomPadding()) // Отступ под BottomNav
        ) {
            PreviewCinema(screenWidth, imageAlpha, backgroundColor)
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it })
            ContinueView()
            NewView()
            NeedToWatchView()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.DarkGray),
        singleLine = true,
        placeholder = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text("Поиск", color = Color.Gray)
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Поиск"
            )
        },
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { /* Выполнить поиск */ }
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}
@Composable
fun ContinueView(){
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween ) {
            Text(
                "Продолжить просмотр",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {},

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
            itemsIndexed(ConstansOfFilms.FilmItems) { _, item ->
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
@Composable
fun NewView(){
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween ) {
            Text(
                "Новинки",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {},
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
                    .background(Color.DarkGray)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .size(40.dp),
                ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "к новинкам"
                )
            }
        }
        LazyRow (modifier = Modifier
            .height(300.dp)) {
            itemsIndexed(ConstantsOfFilms2.FilmItems) { _, item ->
                Box(){
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        modifier = Modifier.height(250.dp)
                            .width(200.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text (
                        item.label,
                        modifier = Modifier.padding(top = 245.dp, start = 15.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        item.genre,
                        modifier = Modifier.padding(top = 263.dp, start = 15.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                }

            }
        }
    }
}
@Composable
fun NeedToWatchView(){
    Column {
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween ) {
            Text(
                "Смотрите",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            IconButton(onClick = {},
                modifier = Modifier.clip(RoundedCornerShape(50.dp))
                    .background(Color.DarkGray)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .size(40.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "к рекомендациям"
                )
            }
        }
        LazyRow (modifier = Modifier
            .height(300.dp)) {
            itemsIndexed(ConstantsOfFilms2.FilmItems) { _, item ->
                Box(){
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = "",
                        modifier = Modifier.height(250.dp)
                            .width(200.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text (
                        item.label,
                        modifier = Modifier.padding(top = 245.dp, start = 15.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        item.genre,
                        modifier = Modifier.padding(top = 263.dp, start = 15.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                }

            }
        }
    }
}
@Composable
fun PreviewCinema(screenWidth: Dp, imageAlpha: Float, backgroundColor: Color){
    LazyRow(
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
@Composable
fun ScreenSettings(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Настройки", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun ScreenCategories(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Категории", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun ScreenFavorites(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Избранное", modifier = Modifier.padding(16.dp))
        }
    }
}

