package com.example.absolute_cinema_app.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.absolute_cinema_app.presentation.screens.AuthAndRegisterScreens.RegisterScreen
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories.ScreenCategories
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenFavorites.ScreenFavorites
import com.example.absolute_cinema_app.presentation.screens.AuthAndRegisterScreens.ScreenMailAuth
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ScreenMain
import com.example.absolute_cinema_app.presentation.screens.AuthAndRegisterScreens.ScreenPasswordAuth
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenCategories.ScreenCategory.ScreenCategory
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenSearch.ScreenSearch
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenSettings.ScreenSettings
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.Film.ScreenFilm
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.ContinueWatch.ScreenContinueWatch
import com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenMain.Recomendation.ScreenRecomendation
import com.example.absolute_cinema_app.presentation.theme.Absolute_cinema_appTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Absolute_cinema_appTheme {

                NavHost(
                    navController = navController,
                    startDestination = "ScreenMain"//потом поменять
                ) {
                    composable("ScreenMailAuth") {
                        ScreenMailAuth(
                            navController = navController
                        )
                    }

                    composable("ScreenPasswordAuth"){
                        ScreenPasswordAuth(
                            navController = navController
                        )
                    }
                    composable("ScreenMain"){
                        ScreenMain(
                            navController = navController
                        )
                    }
                    composable("ScreenContinueWatch"){
                        ScreenContinueWatch(
                            navController = navController
                        )
                    }
                    composable("ScreenCategories"){
                        ScreenCategories(
                            navController = navController
                        )
                    }
                    composable("ScreenFavorites"){
                        ScreenFavorites(
                            navController = navController
                        )
                    }
                    composable("ScreenSettings"){
                        ScreenSettings(
                            navController = navController
                        )
                    }
                    composable("ScreenCategory/{genre}") { backStackEntry ->
                        val genre = backStackEntry.arguments?.getString("genre") ?: "Категория"
                        ScreenCategory(genre, navController)
                    }
                    composable("ScreenRecomendation/{Recomendation}" ){
                        backStackEntry ->  val Recomendation = backStackEntry.arguments?.getString("Recomendation") ?: "Категория"
                        ScreenRecomendation(Recomendation, navController)
                    }
                    composable("RegisterScreen") {
                        RegisterScreen(
                            navController = navController
                        )
                    }

                    composable("ScreenSearch"){
                        ScreenSearch(
                            navController = navController
                        )
                    }
                    composable("ScreenFilm/{kinopoiskId}"){
                            backStackEntry ->
                        val kinopoiskId = backStackEntry.arguments?.getString("kinopoiskId")?.toIntOrNull() ?: 301
                        ScreenFilm(kinopoiskId, navController)
                    }
                }
            }
        }
    }
}

