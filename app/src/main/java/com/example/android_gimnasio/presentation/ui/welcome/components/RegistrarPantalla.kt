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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun RegistrarPantalla(
    onClickRegistro: () -> Unit,
    email: String,
    password: String,
    confirmationPassword: String,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    onValueChangeConfirmationPassword: (String) -> Unit,
    onClickSignIn: (Int)-> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.imagen_pantalla_registro),
                contentDescription = "Imagen pantalla de registro",
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
                        endY = 910f
                    )
                )
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(40.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .weight(3f)
            )
            Text(
                "BODY GOALS\n" +
                        "WORKOUT",
                letterSpacing = 0.1.em,
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            TextField(
                value = email,
                onValueChange = onValueChangeEmail,
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                ),
                label = {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_email_24),
                            contentDescription = "Icono de login"
                        )
                        Text(
                            "Email",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
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
                            "Password",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.1f)
            )
            TextField(
                value = confirmationPassword,
                onValueChange = onValueChangeConfirmationPassword,
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
                            "Confirmation password",
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }

                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.1f)
            )
            Button(
                onClick = onClickRegistro,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                content = {
                    Text(
                        "Sign Up",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Row(
                modifier = Modifier
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .clip(RectangleShape)
                        .background(Color.White)

                )
                Text("Or", color = Color.White)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .clip(RectangleShape)
                        .background(Color.White)
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)

            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_apple),
                            contentDescription = "Icono de apple"
                        )
                    }
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Icono de apple"
                        )
                    }
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    content = {
                        Image(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Icono de apple"

                        )
                    }
                )
            }
            Row(
                modifier = Modifier.
                padding(top = 15.dp, bottom = 30.dp)
            ) {
                Text(
                    "Didn’t have any account?",
                    style = TextStyle(
                        color = Color.White
                    ),
                    fontSize = 14.sp
                )
                ClickableText(
                    text = AnnotatedString(" Sign In here"),
                    style = TextStyle(
                        color = Color.Yellow,
                    ),
                    onClick = onClickSignIn
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegistrarPantallaPreview() {
    AndroidgimnasioTheme {
        RegistrarPantalla(
            onClickRegistro = {},
            email = "",
            confirmationPassword = "",
            password = "",
            onValueChangeEmail = {},
            onValueChangeConfirmationPassword = {},
            onValueChangePassword = {},
            onClickSignIn = {}
        )
    }
}
