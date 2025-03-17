package com.example.absolute_cinema_app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenCategories
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenFavorites
import com.example.absolute_cinema_app.screens.AuthScreens.ScreenMailAuth
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenMain
import com.example.absolute_cinema_app.screens.AuthScreens.ScreenPasswordAuth
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenCategory
import com.example.absolute_cinema_app.screens.ContentScreens.ScreenSettings
import com.example.absolute_cinema_app.ui.theme.Absolute_cinema_appTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Absolute_cinema_appTheme {

                NavHost(
                    navController = navController,
                    startDestination = "ScreenCategories"//потом поменять
                ) {
                    composable("ScreenMailAuth") {
                        ScreenMailAuth(
                            onClickEnter = { navController.navigate("ScreenPasswordAuth") },
                        )
                    }
                    composable("ScreenPasswordAuth"){
                        ScreenPasswordAuth(
                            onClickBack = { navController.navigate("ScreenMailAuth")},
                            onClickAuth = {navController.navigate("ScreenMain")}
                        )
                    }
                    composable("ScreenMain"){
                        ScreenMain(
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
                }
            }
        }
    }
}

