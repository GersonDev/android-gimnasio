package com.example.android_gimnasio.presentation.main.components

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Blue)
    ) {
        Column {
            Text("Today Workout Plan")
            TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson", "carlos", "ronaldo", "gerson"))
        }

        Column {
            Text("Today Workout Plan")
            TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson", "carlos", "ronaldo", "gerson"))
        }

        Column {
            Text("Today Workout Plan")
            TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson", "carlos", "ronaldo", "gerson"))
        }

        Column {
            Text("Today Workout Plan")
            TodayWorkOutPlan(listOf("carlos", "ronaldo", "gerson", "carlos", "ronaldo", "gerson"))
        }
    }
}

@Composable
private fun TodayWorkOutPlan(messages: List<String>) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(start = 10.dp)
    ) {
        messages.forEach { _ ->
            Card(
                modifier = Modifier
                    .width(140.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.imagen_jogging),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        "Jogging",
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePantallaPreview() {
    TodayWorkOutPlan(listOf("carlos"))
}