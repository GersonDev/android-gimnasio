package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun RegistrarPantalla(
    onClickRegistro: () -> Unit,
    onClickCondiciones: () -> Unit,
    onClickPrivacidad: () -> Unit,
    nombre: String,
    correo: String,
    contraseña: String

) {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.gimnasio1),
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
                "Registrarse",
                fontSize = 30.sp,
                color = Color.Blue,
                modifier = Modifier.border(1.dp, Color.Blue).background(Color.LightGray),
                style = MaterialTheme.typography.body1
            )
            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )
            TextField(value = nombre,
                onValueChange = {},
                modifier = Modifier.border(1.dp, Color.Black),
                label = {
                    Text(
                        "Nombre del usuario",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )
            TextField(value = correo,
                onValueChange = {},
                modifier = Modifier.border(1.dp, Color.Black),
                label = {
                    Text(
                        "Correo electronico",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )
            TextField(value = contraseña,
                onValueChange = {},
                modifier = Modifier.border(1.dp, Color.Black),
                label = {
                    Text(
                        "Contraseña",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1
                    )
                })
            Spacer(
                modifier = Modifier
                    .weight(0.2f)
            )
            Button(onClick = onClickRegistro,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                border = BorderStroke(1.5.dp, Color.White),
                content = {
                    Text(
                        "REGISTRARSE",
                        color = Color.White,
                        style = MaterialTheme.typography.body1
                    )
                })
            Spacer(
                modifier = Modifier
                    .weight(0.1f)
            )
            Row {
                Button(onClick = onClickCondiciones,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    contentPadding = PaddingValues(1.dp),
                    border = BorderStroke(1.5.dp, Color.Black),
                    content = {
                        Text(
                            "Aceptar condiciones",
                            fontSize = 10.sp,
                            style = MaterialTheme.typography.body1
                        )
                    })
                Spacer(modifier = Modifier.width(45.dp))
                Button(onClick = onClickPrivacidad,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    contentPadding = PaddingValues(2.dp),
                    border = BorderStroke(1.5.dp, Color.Black),
                    shape = CircleShape,
                    content = {
                        Text(
                            "Politica de privacidad",
                            fontSize = 10.sp,
                            color = Color.Blue,
                            style = MaterialTheme.typography.body1
                        )
                    })
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Text(
                "STRONG FITNESS",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
            Spacer(
                modifier = Modifier.weight(0.5f)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegistrarPantallaPreview() {
    AndroidgimnasioTheme {
        RegistrarPantalla(
            onClickRegistro = {},
            onClickCondiciones = {},
            onClickPrivacidad = {},
            nombre = "",
            correo = "",
            contraseña = "",
        )
    }
}
