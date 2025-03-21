package com.example.absolute_cinema_app.screens.ContentScreens.ScreenSearch


import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.retroifit.FilmsRetrofit.Film
import com.example.absolute_cinema_app.retroifit.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenCategory.FilmRow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSearch(navController: NavController) {
    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    val searchText = rememberSaveable { mutableStateOf("") }

    val mainList = rememberSaveable { mutableStateOf(Utils.UtilsList) }

    val isActive = remember { mutableStateOf(false) }

    val filmState = remember { mutableStateOf<List<Film>>(emptyList()) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)

    val composableScope = rememberCoroutineScope()

    val isLoading = remember { mutableStateOf(false) }


    val searchFilms = { query: String ->
        composableScope.launch {
            if (query.isNotEmpty()) {
                isLoading.value = true
                try {
                    val films = filmApi.getFilmsByKeyword(query, 1)
                    filmState.value = films.films
                    Log.d("Films", "Полученные фильмы: ${films.films}")
                } catch (e: Exception) {
                    Log.e("Server", "Ошибка: ${e.message}")
                    filmState.value = emptyList()
                }
                isLoading.value = false
            } else {
                filmState.value = emptyList()
                isLoading.value = false
            }
        }
    }


    val focusManager = LocalFocusManager.current


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Поиск",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 55.dp)
        ) {
            // Search Bar
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                query = searchText.value,
                onQueryChange = { text -> searchText.value = text },
                onSearch = {text ->
                    isActive.value = false
                    focusManager.clearFocus()
                    searchFilms(searchText.value)

                },
                active = isActive.value,
                onActiveChange = { isActive.value = it },
                placeholder = { Text("Поиск", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Поиск",
                        tint = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                colors = SearchBarDefaults.colors(
                    containerColor = Color.DarkGray,
                    inputFieldColors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    )
                ),
                shape = RoundedCornerShape(12.dp)
            )
            {//история
                LazyColumn (modifier = Modifier
                    .fillMaxWidth()){
                    items(mainList.value){ item ->
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                mainList.value = Utils.searchFilter(item)
                            },
                            contentAlignment = Alignment.Center) {
                            Text(text = item)
                        }
                    }
                }
            }//основной список
            LazyColumn{
                if (searchText.value.isNullOrEmpty())
                {
                    item{
                        Text("введите текст для поиска")
                    }
                }
                else {
                    if (filmState.value.isNullOrEmpty()) {
                        item {
                            Text(
                                text = "Загрузка...",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }
                    } else {
                        items(filmState.value) { film ->
                            Log.d("FilmItem", film.toString())
                            FilmRow(film,screenWidth)
                        }
                    }
                }
            }
        }

    }
}
//
object Utils{
    val UtilsList = listOf(
        "абв",
        "бвг",
        "вгд",
        "где"
    )
    fun searchFilter(text:String): List<String>{//List<String> можно поменять String на любой тип дата класса
// а миенно тут мы используем String чтобы вернуть прдыдущие элементы списка где как раз только строки
        return UtilsList.filter {
            it.lowercase().startsWith(text.lowercase())
        }
    }
}








