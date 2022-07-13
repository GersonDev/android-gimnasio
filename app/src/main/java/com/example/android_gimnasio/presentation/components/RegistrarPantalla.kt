package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrarPantalla(
    onClickRegistro: () -> Unit,
    onClickCondiciones:()->Unit,
    onClickPrivacidad: ()->Unit,
    nombre: String,
    correo: String,
    contraseña: String

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Registrarse",
            fontSize = 16.sp,
            color = Color.Blue,
            modifier = Modifier.border(1.dp, Color.Blue,shape = CircleShape),
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.width(25.dp))
        TextField(value = nombre,
            onValueChange = {},
            modifier = Modifier.border(1.dp, Color.Black),
            label = {
                Text("Ingrese nombre", textAlign = TextAlign.Center)
            }
        )
        TextField(value = correo,
            onValueChange = {},
            modifier = Modifier.border(1.dp, Color.Black),
            label = {
                Text("Correo electronico", textAlign = TextAlign.Center)
            }
        )
        TextField(value = contraseña,
            onValueChange = {},
            modifier = Modifier.border(1.dp, Color.Black),
            label = {
                Text("Contraseña", textAlign = TextAlign.Center)
            })
        Button(onClick = onClickRegistro,colors = ButtonDefaults . buttonColors ( backgroundColor = Color.Blue ),border = BorderStroke(1.5.dp, Color.White),
            content = {
                Text(
                    "REGISTRARSE",color=Color.White
                )
            })
        Row() {
            Button(onClick = onClickCondiciones, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), contentPadding = PaddingValues(1.dp), border = BorderStroke(1.5.dp, Color.Black),
            content = {
                Text(
                    "Aceptar condiciones", fontSize = 8.sp
                )
            })
            Spacer(modifier = Modifier.width(25.dp))
            Button(onClick = onClickPrivacidad, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), contentPadding = PaddingValues(2.dp),border = BorderStroke(1.5.dp, Color.Black),
                shape = CircleShape,
                content = {
                Text(
                    "Politica de privacidad", fontSize = 8.sp, color = Color.Blue
                )
            })
        }
        Text(
            "STRONG FITNESS",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun RegistrarPantallaPreview() {
    RegistrarPantalla(
        onClickRegistro = {},
        onClickCondiciones = {},
        onClickPrivacidad = {},
        nombre = "",
        correo = "",
        contraseña = "",

        )
}