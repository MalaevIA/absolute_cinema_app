package com.example.absolute_cinema_app.presentation.screens.AuthAndRegisterScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.R
import com.example.absolute_cinema_app.domain.RegisterRetrfit.RegisterAPI
import com.example.absolute_cinema_app.domain.RegisterRetrfit.UserRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    val retrofit = Retrofit.Builder().baseUrl("http://158.160.173.175:8080").client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val registerAPI = retrofit.create(RegisterAPI::class.java)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Регистрация") }
            )
        },
        contentWindowInsets = WindowInsets.ime
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chair),
                    modifier = Modifier
                        .width(200.dp)
                        .height(220.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                fontWeight = FontWeight.Bold,
                text = "Введите данные для регистрации"
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                style = androidx.compose.ui.text.TextStyle(color = Color.White.copy(alpha = 0.5f)),
                text = "Введите адрес электронной почты и придумайте пароль"
            )

            var textMail by remember { mutableStateOf("") }

            var textPassword by remember { mutableStateOf("") }

            TextField(
                value = textMail,
                onValueChange = { textMail = it },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.auth_mail_ru),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier
                    .padding(top = 16.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = textPassword,
                onValueChange = { textPassword = it },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.auth_password_ru),
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                    .padding(top = 16.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            if (textPassword.isNotEmpty() and textMail.isNotEmpty()) {
                Button(
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            val user = registerAPI.Register(
                                UserRequest(textMail,textPassword)
                            )
                        }
                    },
                    modifier = Modifier.padding(top = 250.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFEB3B),
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Зарегистрироваться!")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.align(Alignment.Start)
                .padding(bottom = 16.dp)){
                val annotatedText = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.DarkGray)){
                        append("Продолжая, вы соглашаетесь с нашей ")
                    }
                    pushStringAnnotation(tag = "policy", annotation = "https://example.com/privacy")
                    append("политикой конфиденциальности")
                    pop()
                }
                Text(
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    text = annotatedText
                )
            }
        }
    }
}

