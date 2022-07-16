package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.gym1),
            contentDescription = "Logo Gimnasio",
            contentScale = ContentScale.FillBounds
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                "Iniciar Sesion",
                color = Color.Blue,
                style = MaterialTheme.typography.h1,
                fontSize = 45.sp
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            TextField(
                value = correo,
                onValueChange = onValueChangeCorreo,
                modifier = Modifier.border(1.dp, color = Color.Black),
                label = {
                    Text(
                        "Ingrese Correo Electronio:",
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.3f)
            )
            TextField(
                value = password,
                onValueChange = onValueChangePassword,
                modifier = Modifier.border(1.dp, Color.Black),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = {
                    Text(
                        "Contraseña",
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.3f)
            )
            Button(onClick = onClickLoginPantalla,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                modifier = Modifier.width(200.dp),
                content = {
                    Text(
                        "Ingresar",
                        color = Color.White,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
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