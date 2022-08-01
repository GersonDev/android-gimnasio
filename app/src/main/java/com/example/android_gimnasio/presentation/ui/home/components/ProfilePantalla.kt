package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R

@Composable
fun ProfilePantalla(
    onClickActualizar: () -> Unit,
    onValueChangeEmail: (String) -> Unit,
    onValueChangePassword: (String) -> Unit,
    email: String,
    password: String,
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    colorResource(R.color.trainers_primary)
                )
                .padding(40.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.img_user_profile),
                contentDescription = "Imagen de profile",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            )
            Text(
                text = "Actualizar Perfil:",
                letterSpacing = 0.1.em,
                fontSize = 17.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            TextField(
                value = "",
                onValueChange = { },
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
                            "Nombre",
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
                    .weight(0.2f)
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
                    .weight(0.2f)
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
            Button(
                onClick = onClickActualizar,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, bottom = 50.dp),
                content = {
                    Text(
                        "Actualizar",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun ProfilePantallaPreview() {
    ProfilePantalla(
        {},
        {},
        {},
        "", ""
    )
}