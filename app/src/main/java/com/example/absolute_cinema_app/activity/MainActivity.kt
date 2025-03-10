package com.example.absolute_cinema_app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.absolute_cinema_app.screens.ScreenMailAuth
import com.example.absolute_cinema_app.screens.ScreenMain
import com.example.absolute_cinema_app.screens.ScreenPasswordAuth
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
                    startDestination = "ScreenMailAuth"
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
                        ScreenMain()
                    }
                }
            }
        }
    }
}

