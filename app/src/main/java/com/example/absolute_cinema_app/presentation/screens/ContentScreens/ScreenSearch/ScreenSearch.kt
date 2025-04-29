package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenSearch

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmAPI
import com.example.absolute_cinema_app.domain.FilmsRetrofit.FilmForSearch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HISTORY_PREF = "exHistory"
const val KEY_HISTORY = "History"
@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSearch(navController: NavController) {


    val configuration: Configuration = LocalConfiguration.current
    val screenWidth: Dp = configuration.screenWidthDp.dp
    var searchText by rememberSaveable { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }


    val context = LocalContext.current
    val sharedPrefs = remember { context.getSharedPreferences(HISTORY_PREF, Context.MODE_PRIVATE) }
    val gson = remember { Gson() }

    var historyList = remember {
        mutableStateListOf<String>().apply {
            addAll(getHistory(sharedPrefs, gson))
        }
    }


    var filmState by remember { mutableStateOf<List<FilmForSearch>>(emptyList()) }

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofitInstance = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val filmApi = retrofitInstance.create(FilmAPI::class.java)

    val composableScope = rememberCoroutineScope()

    var isLoading by remember { mutableStateOf(false) }

    var isError by remember { mutableStateOf(false) }

    fun checkInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
    var isNetworkAvailable by remember { mutableStateOf(checkInternetConnection(context)) }
    val searchFilms = { query: String ->
        composableScope.launch {
            if (!checkInternetConnection(context)) {
                isNetworkAvailable = false
                isLoading = false
                return@launch
            }
            if (query.isNotEmpty()) {
                isLoading = true
                isError = false
                isNetworkAvailable = true
                try {
                    val films = filmApi.getFilmsByKeyword(query, 1)
                    filmState = films.films
                    isError = films.films.isEmpty()
                } catch (e: Exception) {
                    isError = true
                    filmState = emptyList()
                }
                isLoading = false
            } else {
                filmState = emptyList()
                isLoading = false
            }
        }
    }
    var debounceJob: Job? = null


    fun debounceSearch(query: String) {
        debounceJob?.cancel()

        debounceJob = composableScope.launch {
            delay(2000)
            if (query.isNotEmpty()) {
                searchFilms(query)
            }
        }
    }


    val focusManager = LocalFocusManager.current


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Поиск",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
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
                query = searchText,
                onQueryChange = { searchText = it
                    debounceSearch(it)
                                },
                onSearch = {text ->
                    isActive = false
                    focusManager.clearFocus()
                    searchFilms(searchText)
                    sharedPrefs.edit().putString(KEY_HISTORY,searchText).apply()
                    if (text.isNotBlank() && !historyList.contains(text)) {
                        historyList.add(0, text)
                        if (historyList.size > 10) {
                            historyList.removeLast()
                        }
                        saveHistory(sharedPrefs, gson, historyList)
                    }
                },
                active = isActive,
                onActiveChange = { isActive = it },
                placeholder = { Text("Поиск", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Поиск",
                        tint = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                },
                trailingIcon = {
                    if(isActive){
                        Icon(
                            modifier = Modifier.clickable {
                                if(searchText.isNotEmpty()){
                                    searchText = ""
                                }else{
                                    isActive = false
                                }

                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Поиск",
                            tint = Color.Gray,
                        )
                    }
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

                historyList.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 14.dp)
                            .clickable { searchText = item },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.History,
                                contentDescription = "History Icon",
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(text = item)
                        }

                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete Icon",
                            modifier = Modifier
                                .clickable { historyList.remove(item) }
                                .padding(start = 10.dp)
                        )
                    }
                }

            }//основной список
            LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)){
                if (searchText.isNullOrEmpty())
                {
                    item{
                        Column (modifier = Modifier.fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = R.drawable.camera),
                                contentDescription = "",
                                modifier = Modifier.width((screenWidth/5)*4).height((screenWidth/5)*4),
                                contentScale = ContentScale.Fit,

                                )
                            Text("Введите текст для поиска",
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                else {
                     if (filmState.isEmpty() && searchText.isNotEmpty() && !isLoading) {
                             item {
                                 Column(
                                     modifier = Modifier.fillMaxSize(),
                                     verticalArrangement = Arrangement.Center,
                                     horizontalAlignment = Alignment.CenterHorizontally
                                 ) {
                                     Text("Ничего не найдено")
                                 }
                             }
                    }
                    else if (filmState.isNullOrEmpty()) {
                        item {//загрузка
                            Column (modifier = Modifier.fillParentMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center){
                                CircularProgressIndicator(
                                    modifier = Modifier.size(100.dp),
                                    color = Color.DarkGray,
                                    strokeWidth = 10.dp
                                )
                            }
                        }
                    }
                    if (!isNetworkAvailable) {
                        item {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Нет подключения к интернету")
                                Button(onClick = { searchFilms(searchText) }) {
                                    Text("Повторить")
                                }
                            }
                        }
                    }
                    else {
                        items(filmState) { film ->

                            Log.d("FilmItem", film.toString())
                            FilmRowForSearch(film,screenWidth,navController)
                        }
                    }
                }
            }
        }

    }
}

fun saveHistory(prefs: SharedPreferences, gson: Gson, history: List<String>) {
    val json = gson.toJson(history)
    prefs.edit().putString(KEY_HISTORY, json).apply()
}
fun getHistory(prefs: SharedPreferences, gson: Gson): List<String> {
    val json = prefs.getString(KEY_HISTORY, null)

    return if (json != null) {
        try {
            gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
        } catch (e: Exception) {
            prefs.edit().remove(KEY_HISTORY).apply()
            emptyList()
        }
    } else {
        emptyList()
    }
}



