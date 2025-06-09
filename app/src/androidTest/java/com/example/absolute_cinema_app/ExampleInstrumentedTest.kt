package com.example.absolute_cinema_app

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.absolute_cinema_app.data.Tokens.TokenManager
import com.example.absolute_cinema_app.data.models.filmsModels.Genre
import com.example.absolute_cinema_app.data.models.filmsModels.VideoResponse
import com.example.absolute_cinema_app.data.themePreference.ThemePreference
import com.example.absolute_cinema_app.domain.viewModels.AuthViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


}