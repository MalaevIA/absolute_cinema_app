package com.example.absolute_cinema_app.presentation.screens.ContentScreens.ScreenSettings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.data.Tokens.TokenManager
import com.example.absolute_cinema_app.data.themePreference.ThemePreference
import com.example.absolute_cinema_app.presentation.screens.Menu.BottomNavigationBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSettings(navController: NavController) {
    val context = LocalContext.current
    val themePref = remember { ThemePreference(context) }
    val isDarkTheme = remember { mutableStateOf(false) }
    val isAuthorized = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Получаем тему из DataStore
    LaunchedEffect(Unit) {
        themePref.themeFlow.collect {
            isDarkTheme.value = it
        }
    }

    // Получаем токен из TokenManager
    LaunchedEffect(Unit) {
        val token = TokenManager.getToken(context)
        isAuthorized.value = token != null
    }

    MaterialTheme(colorScheme = if (isDarkTheme.value) darkColorScheme() else lightColorScheme()) {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            topBar = {
                TopAppBar(
                    title = { Text("Настройки", fontWeight = FontWeight.Bold) }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Тема
                Text("Тема")
                Switch(
                    checked = isDarkTheme.value,
                    onCheckedChange = {
                        isDarkTheme.value = it
                        coroutineScope.launch {
                            themePref.saveTheme(it)
                        }
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Yellow,
                        checkedTrackColor = Color(0xFFFFF59D),
                        uncheckedThumbColor = Color.Gray,
                        uncheckedTrackColor = Color.LightGray
                    )
                )


                Spacer(modifier = Modifier.height(32.dp))

                // Авторизация
                if (isAuthorized.value) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                TokenManager.clearToken(context)
                                navController.navigate("ScreenMailAuth") {
                                    popUpTo("ScreenMain") { inclusive = true }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Yellow,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Выйти из аккаунта")
                    }

                } else {
                    Button(
                        onClick = {
                            navController.navigate("ScreenMailAuth")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Yellow,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Войти или зарегистрироваться")
                    }

                }
            }
        }
    }
}
