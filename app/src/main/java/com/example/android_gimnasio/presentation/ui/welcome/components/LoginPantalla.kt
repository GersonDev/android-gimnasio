package com.example.android_gimnasio.presentation.ui.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
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
    onValueChangePassword: (String) -> Unit,
    onClickSignUp: (Int) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.imagen_de_login),
                contentDescription = "Imagen de login",
                contentScale = ContentScale.FillWidth
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.secondaryVariant
                        ),
                        startY = 0f,
                        endY = 1200f
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
            Image(
                modifier = Modifier.width(100.dp).height(100.dp),
                painter = painterResource(id = R.drawable.ic_app_sf_full),
                contentDescription = "Imagen de strong fitness",
                contentScale = ContentScale.FillWidth
            )
            Text(
                stringResource(R.string.strong_fitness),
                letterSpacing = 0.1.em,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            TextField(
                value = correo,
                onValueChange = onValueChangeCorreo,
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                label = {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_email_24),
                            contentDescription = "Icono de login"
                        )
                        Text(
                            stringResource(id = R.string.email),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .width(266.dp)
                                .height(50.dp),
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.1f)
            )
            TextField(
                value = password,
                onValueChange = onValueChangePassword,
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.icon_contra),
                            contentDescription = "Icono de password"
                        )
                        Text(
                            stringResource(id = R.string.password),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .width(266.dp)
                                .height(50.dp),
                        )
                    }

                }
            )
            Text(
                stringResource(id = R.string.forgot_password),
                color = Color.White,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp)
            )
            Button(
                onClick = onClickLoginPantalla,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 5.dp)
                    .width(326.dp)
                    .height(50.dp),

                content = {
                    Text(
                        stringResource(id = R.string.sign_in),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Row(
                modifier = Modifier.padding(top = 15.dp, bottom = 30.dp)
            ) {
                Text(
                    stringResource(id = R.string.did_not_have_any_account),
                    style = TextStyle(
                        color = White
                    ),
                    fontSize = 14.sp
                )
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.sign_up_here)),
                    style = TextStyle(
                        color = Yellow,
                    ),
                    onClick = onClickSignUp
                )
            }
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
            onValueChangeCorreo = {},
            onClickSignUp = {}
        )
    }
}