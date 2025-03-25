package com.example.absolute_cinema_app.presentation.screens.AuthAndRegisterScreens

import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.absolute_cinema_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMailAuth(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Войти") }
            )
        },
        contentWindowInsets = WindowInsets.ime // Учитываем появление клавиатуры
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding(), // Добавляем отступ для клавиатуры
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Обернем изображение в Box для точного контроля размещения
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp), // Поднимаем картинку выше
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
                text = stringResource(id = R.string.auth_mail_ru)
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                style = androidx.compose.ui.text.TextStyle(color = Color.White.copy(alpha = 0.5f)),
                text = stringResource(id = R.string.auth_mail_description_ru)
            )

            var text by remember { mutableStateOf("") }

            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.auth_mail_ru),
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardActions = KeyboardActions(
                    onDone = { navController.navigate("ScreenPasswordAuth") }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            if (text.isNotEmpty()) {
                Button(
                    onClick = {navController.navigate("ScreenPasswordAuth")},
                    modifier = Modifier.padding(top = 250.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFEB3B),
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Далее")
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
                Column {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                            .clickable { navController.navigate("RegisterScreen") },
                        text = "Регистрация",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Yellow,
                        fontSize = 20.sp,
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                        text = annotatedText
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPasswordAuth(navController: NavController){
    Scaffold(
        topBar = {CenterAlignedTopAppBar(
            title = {
                Text(text = "Войти")
            },
            navigationIcon = {
                IconButton(onClick = {navController.navigate("ScreenMailAuth")}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Назад"
                    )
                }
            }
        )})
    { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding(), // Добавляем отступ для клавиатуры
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Обернем изображение в Box для точного контроля размещения
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp), // Поднимаем картинку выше
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
                text = stringResource(id = R.string.auth_password_ru)
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                style = androidx.compose.ui.text.TextStyle(color = Color.White.copy(alpha = 0.5f)),
                text = stringResource(id = R.string.auth_password_description_ru)
            )

            var text by remember { mutableStateOf("") }

            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.auth_password_ru),
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    textAlign = TextAlign.Center
                ),
                keyboardActions = KeyboardActions(
                    onDone = {navController.navigate("ScreenMain")}
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            if (text.isNotEmpty()) {
                Button(
                    onClick = {navController.navigate("ScreenMain")},
                    modifier = Modifier.padding(top = 250.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFEB3B),
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Войти")
                }
            }
        }
    }
}

