package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun LoginPantalla(
    onClickLoginPantalla: () -> Unit,
    correo: String,
    password: String,
    onValueChangeCorreo: (String) -> Unit,
    onValueChangePassword: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.imagen_de_login),
            contentDescription = "Imagen de login",
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xD7525252),
                        )
                    )
                )
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .weight(3f)
            )
            Text(
                " BODY GOALS\nWORKOUT",
                letterSpacing = 0.3.em,
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            TextField(
                value = correo,
                onValueChange = onValueChangeCorreo,
                modifier = Modifier.background(Color.White),
                label = {
                    Text(
                        "Email",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )
            TextField(
                value = password,
                onValueChange = onValueChangePassword,
                modifier = Modifier.background(Color.White),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = {
                    Text(
                        "Password",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Text(
                "Forgot Password",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp)
            )
            Button(
                onClick = onClickLoginPantalla,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp)
                    .width(326.dp)
                    .height(50.dp) ,

                content = {
                    Text(
                        "Sign In",
                        color = Color.Black,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(Color.White),
                    ) {
                        append(
                            "Didn’t have any account?"
                        )
                    }
                    withStyle(
                        style = SpanStyle(Color.Yellow)
                    ) {
                        append("Sign Up here")
                    }
                },
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 15.dp, bottom = 70.dp),
                fontSize = 14.sp
            )
        }
    }
}


@Preview
@Composable
private fun LoginPantallaPreview() {
    AndroidgimnasioTheme {
        LoginPantalla(
            onClickLoginPantalla = { /*TODO*/ },
            correo = "",
            password = "",
            onValueChangePassword = {},
            onValueChangeCorreo = {}
        )
    }
}