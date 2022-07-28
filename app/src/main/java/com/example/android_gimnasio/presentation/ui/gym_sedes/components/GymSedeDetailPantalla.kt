package com.example.android_gimnasio.presentation.ui.gym_sedes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_gimnasio.R

@Composable
fun GymSedeDetailPantalla() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colors.secondaryVariant
                    ),
                    startY = 0f,
                    endY = 1200f
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.golds_gimnasio),
            contentDescription = "Imagen de Golds Gym",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillBounds
        )


    }
}

@Composable
private fun GymSedeDetailPantallaPreview() {
    GymSedeDetailPantalla()
}