package com.example.absolute_cinema_app.screens.ContentScreens.ScreenSettings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.screens.Menu.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSettings(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) } ,
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