package com.example.absolute_cinema_app.FilmsData

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class FilmItem(
    val label: String,
    val icon: Int,
    val genre: String,
    val days_from_the_beginning_of_viewing: Int,
)
