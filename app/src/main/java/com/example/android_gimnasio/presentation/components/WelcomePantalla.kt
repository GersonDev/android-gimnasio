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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

@Composable
fun WelcomePantalla(onClickStarted:()->Unit) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.imagen_de_bienvenida_gimnasio),
            contentDescription = "Logo de Gimnasio",
            contentScale = ContentScale.FillBounds
        )
        Box(
            contentAlignment = Alignment.Center
        ) {

           Box(modifier = Modifier
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
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(3f)
                )
                Text(
                    "Welcome to",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2
                )
                Text(
                    " BODY GOALS\nWORKOUT",
                    letterSpacing = 0.2.em,
                    fontSize = 32.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1
                )
                Text(
                    "Achieve your body goals with us",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1
                )
                Button(
                    onClick = onClickStarted,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                    modifier = Modifier.padding(top = 33.dp, bottom = 70.dp).width(244.dp).height(55.dp),

                    content = {
                        Text("Get Started", color = Color.Black,
                            style = MaterialTheme.typography.h4)
                    })

            }
        }
    }
}

@Preview
@Composable
 private fun WelcomepantallaPreview() {
    AndroidgimnasioTheme() {
        WelcomePantalla(onClickStarted = {})
    }
}