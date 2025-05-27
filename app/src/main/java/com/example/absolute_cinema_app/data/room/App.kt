package com.example.absolute_cinema_app.data.room

import android.app.Application

class App:Application() {
    val database by lazy { ContinueFilmsDB.CreateDB(this) }
}