package com.example.android_gimnasio.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
fun LogearsePantalla(
    onClickButtonOne: () -> Unit,
    onClickButtonTwo: () -> Unit,
    onClickButtonThree: () -> Unit
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
            contentScale = ContentScale.FillWidth
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                "BIENVENIDOS A STRONG \n FITNESS",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            Text(
                "TUS MEJORES OPCIONES \nDE ENTRENAMIENTO",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
            Spacer(
                modifier = Modifier
                    .weight(3f)
            )
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
                        val painter: Painter= painterResource(id = R.drawable.ic_baseline_account_circle_24)
                        Image(painter = painter, contentDescription = "Logo de Iniciar Sesion", modifier = Modifier.width(20.dp))
                        Text("Iniciar sesion", color = Color.White)
                    })
            }
            Spacer(
                modifier =
                Modifier
                    .weight(3f)
            )
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
            Spacer(
                modifier = Modifier
                    .weight(2f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LogearsePreview() {
    AndroidgimnasioTheme {
        LogearsePantalla(onClickButtonOne = { /*TODO*/ },
            onClickButtonTwo = {},
            onClickButtonThree = {}
        )
    }
}