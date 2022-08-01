package com.example.android_gimnasio.presentation.ui.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
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
                modifier = Modifier
                    .padding(50.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(3f)
                )
                Text(
                    stringResource(R.string.welcome_to),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h3
                )
                Text(
                    stringResource(R.string.strong_fitness),
                    letterSpacing = 0.2.em,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1
                )
                Text(
                    stringResource(R.string.achieve_your_body_goals),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 37.dp)
                )
                Button(
                    onClick = onClickStarted,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.width(244.dp).height(55.dp),
                    content = {
                        Text(stringResource(R.string.get_started), color = Color.Black,
                            style = MaterialTheme.typography.button)
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