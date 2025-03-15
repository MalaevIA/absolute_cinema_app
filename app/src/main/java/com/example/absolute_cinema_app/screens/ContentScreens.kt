package com.example.absolute_cinema_app.screens
import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import com.example.absolute_cinema_app.FilmsData.CategoryData
import com.example.absolute_cinema_app.FilmsData.ConstansOfCategory
import com.example.absolute_cinema_app.FilmsData.ConstansOfFilms
import com.example.absolute_cinema_app.FilmsData.ConstantsOfFilms2
import com.example.absolute_cinema_app.FilmsData.ConstantsOfFilms3
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

            SearchBar(query = searchQuery, onQueryChange = { searchQuery = it })

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
            itemsIndexed(ConstantsOfFilms3.FilmItems) { _, item ->
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
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FirstCategoryRow(backgroundColor)

            SecondCategoryRow(screenWidth, backgroundColor)

            ThirdCategoryRow(backgroundColor)

            FourthCategoryRow(screenWidth, backgroundColor)

            FifthCategoryRow(screenWidth, backgroundColor)

            SixthCategoryRow(backgroundColor)
        }
    }
}


@Composable
fun FirstCategoryRow(backgroundColor: Color) {
    Row(modifier = Modifier.height(200.dp)) {
        Box(modifier = Modifier.padding(start = 8.dp).height(200.dp)) {
            Image(
                painter = painterResource(id = ConstansOfCategory.CategoryItems[0].icon),
                contentDescription = "",
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight()
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
                    .width(150.dp)
                    .padding(top = 170.dp, start = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 15.sp
            )
        }
        Box(modifier = Modifier.padding(start = 8.dp)) {
            LazyColumn(userScrollEnabled = false) {
                itemsIndexed(ConstansOfCategory.CategoryItems.slice(1..2)) {_, item ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp, end = 8.dp)
                            .width(300.dp)
                            .height(96.dp)
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
                                .padding(top = 66.dp, start = 8.dp),
                            textAlign = TextAlign.Start,
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
fun ThirdCategoryRow(backgroundColor: Color) {
    Row(
        modifier = Modifier.height(200.dp)
    ) {
        Box(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
            LazyColumn(userScrollEnabled = false) {
                itemsIndexed(ConstansOfCategory.CategoryItems.slice(5..6)) {_, item ->
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width(250.dp)
                            .height(96.dp)
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
                                .padding(top = 66.dp, start = 8.dp),
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
                .height(200.dp)
                .width(150.dp)
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
                    .width(150.dp)
                    .padding(top = 170.dp, start = 8.dp),
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
        itemsIndexed(ConstansOfCategory.CategoryItems.slice(8..9)) {_, item ->
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
        itemsIndexed(ConstansOfCategory.CategoryItems.slice(10..12)) {_, item ->
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
fun SixthCategoryRow(backgroundColor: Color) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(200.dp)
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
                .padding(top = 170.dp, start = 8.dp),
            textAlign = TextAlign.Start,
            fontSize = 15.sp
        )

    }
}



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
                IconButton(onClick = { /* Действие при нажатии */ }) {
                    Icon(
                        imageVector = Icons.Default.List, // Заменить на свой ресурс
                        contentDescription = "фильтры"
                    )
                }
            }
        ) }
    ) { paddingValues ->
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()){
            Column (modifier = Modifier.padding(bottom = 100.dp) ){
                Image(
                    painter = painterResource(R.drawable.snapedit_png),
                    contentDescription = "",
                    modifier = Modifier.width(screenWidth/2)
                        .height(screenWidth/2)
                )
                Text("Список закладок пока пуст")
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSettings(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController)} ,
        topBar = { TopAppBar(
            title = { Text(text = "Настройки", fontWeight = FontWeight.Bold)
            }) },

    )
        { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Переключатель темы (Светлая/Темная)
            Text("Тема")
            Switch(
                checked = true, // состояние переключателя (например, из ViewModel)
                onCheckedChange = { /* действие при изменении */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Язык приложения
            Text("Язык")
            DropdownMenu(
                expanded = false,
                onDismissRequest = { /* действие */ }
            ) {
                // Здесь можно вывести список доступных языков
                DropdownMenuItem(onClick = { /* действие */ }) {
                    Text("Русский")
                }
                DropdownMenuItem(onClick = { /* действие */ }) {
                    Text("English")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Уведомления
            Text("Уведомления")
            Switch(
                checked = true, // состояние уведомлений
                onCheckedChange = { /* действие при изменении */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Рекомендации
            Text("Рекомендации")
            Column {
                Row {
                    Checkbox(
                        checked = true, // состояние фильтра
                        onCheckedChange = { /* действие */ }
                    )
                    Text("Жанры")
                }
                Row {
                    Checkbox(
                        checked = true,
                        onCheckedChange = { /* действие */ }
                    )
                    Text("Год выпуска")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // О нас / Справка
            Text("О нас")
            TextButton(onClick = { navController.navigate("about") }) {
                Text("Подробнее")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Вход / Регистрация
            Text("Аккаунт")
            TextButton(onClick = { navController.navigate("login") }) {
                Text("Войти")
            }
        }
    }
}

fun DropdownMenuItem(onClick: () -> Unit, interactionSource: @Composable () -> Unit) {

}

