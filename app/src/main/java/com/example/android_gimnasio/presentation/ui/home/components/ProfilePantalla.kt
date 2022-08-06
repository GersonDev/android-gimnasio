package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    onClickCerrarSesion: () -> Unit,
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
                .verticalScroll(rememberScrollState())
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
                painter = painterResource(id = R.drawable.ic_user_profile_picture),
                contentDescription = "Imagen de profile",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(CircleShape)
            )
            Text(
                stringResource(id = R.string.update_profile),
                letterSpacing = 0.1.em,
                fontSize = 17.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(2.dp, Color.Gray, RectangleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Clases Pendientes ",
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(2.dp, Color.Gray, RectangleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Evaluar esta Aplicacion ",
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
                Spacer(
                    modifier = Modifier.width(20.dp)
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Back",
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Back",
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .border(2.dp, Color.Gray, RectangleShape),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Recomendaciones ",
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }


            Spacer(
                modifier = Modifier
                    .height(20.dp)
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
                            stringResource(id = R.string.name),
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
                            stringResource(id = R.string.email),
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
                            stringResource(id = R.string.password),
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
                    .padding(top = 50.dp, bottom = 5.dp),
                content = {
                    Text(
                        stringResource(id = R.string.update),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Button(
                onClick = onClickCerrarSesion,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp),
                content = {
                    Text(
                        stringResource(id = R.string.log_out),
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
        {},
        "", ""
    )
}