package com.example.absolute_cinema_app.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings

object ConstantsOfBottomNav {
    val BottomNavItems = listOf(
        // Home screen
        BottomNavItem(
            label = "Главная",
            icon = Icons.Filled.Home,
            route = "ScreenMain"
        ),
        // Search screen
        BottomNavItem(
            label = "Категория",
            icon = Icons.Filled.Menu,
            route = "ScreenCategories"
        ),
        // Profile screen
        BottomNavItem(
            label = "Закладки",
            icon = Icons.Filled.Favorite,
            route = "ScreenFavorites"
        ),
        BottomNavItem(
            label = "Насторойки",
            icon = Icons.Filled.Settings,
            route = "ScreenSettings"
        )
    )
}