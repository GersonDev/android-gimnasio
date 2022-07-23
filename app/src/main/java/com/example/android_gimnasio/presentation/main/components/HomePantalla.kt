package com.example.android_gimnasio.presentation.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R

@Composable
fun HomePantalla() {
    Column {
        Text("Today Workout Plan")
        TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson", "carlos", "ronaldo", "gerson"))
    }
}

@Composable
private fun TodayWorkOutPlan(messages: List<String>) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        messages.forEach { _ ->
            Card {
                Box {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.imagen_jogging),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePantallaPreview() {
    TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson"))
}