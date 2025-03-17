package com.example.absolute_cinema_app.screens.Menu

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
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





