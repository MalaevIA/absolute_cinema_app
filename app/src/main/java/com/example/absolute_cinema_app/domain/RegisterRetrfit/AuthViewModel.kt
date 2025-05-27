package com.example.absolute_cinema_app.domain.RegisterRetrfit

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val _isAuthorized = mutableStateOf(false)
    val isAuthorized: State<Boolean> = _isAuthorized

    init {
        checkAuthorization()
    }

    fun checkAuthorization() {
        viewModelScope.launch(Dispatchers.IO) {
            val context = getApplication<Application>().applicationContext
            val token = TokenManager.getToken(context)
            _isAuthorized.value = !token.isNullOrEmpty()
        }
    }
}
