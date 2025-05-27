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

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.absolute_cinema_app", appContext.packageName)
    }
    //Тест сохранения и чтения темы из ThemePreference
    @Test
    fun testThemePreference_saveAndLoad() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val themePref = ThemePreference(context)

        themePref.saveTheme(true)
        val value1 = themePref.themeFlow.first()
        assertTrue(value1)

        themePref.saveTheme(false)
        val value2 = themePref.themeFlow.first()
        assertFalse(value2)
    }
    //Тест TokenManager сохранения/чтения токена
    @Test
    fun testTokenManager_saveAndGetToken() = runTest {
        val context = ApplicationProvider.getApplicationContext<Context>()
        TokenManager.saveToken(context, "test_token")

        val token = TokenManager.getToken(context)
        assertEquals("test_token", token)
    }
    //Тест очистки токена
    @Test
    fun testTokenManager_clearToken() = runTest {
        val context = ApplicationProvider.getApplicationContext<Context>()
        TokenManager.saveToken(context, "abc123")
        TokenManager.clearToken(context)

        val token = TokenManager.getToken(context)
        assertNull(token)
    }
    //Тест конвертации жанров в строку
    @Test
    fun testGenresToString() {
        val genres = listOf(Genre("драма"), Genre("комедия"))
        val result = genres.joinToString(", ") { it.genre }
        assertEquals("драма, комедия", result)
    }
    //Тест получения видео из VideoResponse
    @Test
    fun testVideoResponseParsing() {
        val json = """
        {
            "total": 1,
            "items": [
                {"url": "https://youtube.com/watch?v=abc", "name": "Trailer", "site": "YOUTUBE"}
            ]
        }
    """.trimIndent()

        val gson = Gson()
        val response = gson.fromJson(json, VideoResponse::class.java)
        assertEquals(1, response.total)
        assertEquals("Trailer", response.items[0].name)
    }
//    //Тест AuthViewModel на авторизацию
//    @Test
//    fun testAuthViewModel_isAuthorizedTrue() = runTest {
//        val context = ApplicationProvider.getApplicationContext<Application>()
//
//        TokenManager.saveToken(context, "mock_token")
//        val viewModel = AuthViewModel(context)
//
//        val result = viewModel.isAuthorized.value
//        assertTrue(result)
//    }



}