package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogearsePantalla(
    onClickButtonOne: () -> Unit,
    onClickButtonTwo: () -> Unit,
    onClickButtonThree: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.gimnasio1),
            contentDescription = "Logo Gimnasio"
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "BIENVENIDOS A STRONG \n FITNESS",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                "TUS MEJORES OPCIONES \nDE ENTRENAMIENTO",
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onClickButtonTwo,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
                    content = {
                        Text("Registrarse", color = Color.Blue)
                    })
                Spacer(modifier = Modifier.width(25.dp))
                Button(
                    onClick = onClickButtonOne,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    content = {
                        Text("Iniciar sesion", color = Color.White)
                    })
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                "STRONG FITNESS",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Button(onClick = onClickButtonThree, colors = ButtonDefaults.buttonColors(Color.Blue)) {
                val painter: Painter = painterResource(id = R.drawable.img)
                Image(painter = painter, contentDescription = "Logo de Facebook", modifier = Modifier.width(20.dp))
                Text("Continuar con Facebook")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LogearsePreview() {
    LogearsePantalla(onClickButtonOne = { /*TODO*/ },
        onClickButtonTwo = {},
        onClickButtonThree = {}
    )
}