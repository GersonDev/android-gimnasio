package com.example.android_gimnasio.presentation.ui.gym_sedes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Brand
import com.example.android_gimnasio.domain.models.gym.Sede
import com.example.android_gimnasio.presentation.common.components.GymTitle


@Composable
fun GymSedePantalla(sedes: List<Sede>, brand: Brand) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.trainers__primary))
            .padding(start = 10.dp, bottom = 60.dp, top = 20.dp, end = 3.dp)
    ) {

        GymTitle(brand.title, brand.image)

        Spacer(
            modifier = Modifier
                .height(30.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            Text("Today", color = Color.White, fontSize = 20.sp)
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {

                sedes.forEach {
                    GymSedeCelda(it)
                }
            }
        }

    }
}

@Composable
fun GymSedeCelda(
    sede: Sede
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = sede.imagen),
                contentDescription = "Imagen de Golds Gym",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds

            )
        }
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = sede.titulo, color = Color.White, fontSize = 15.sp)
            Text(text = sede.descripcion, color = Color.White, fontSize = 10.sp)
        }
        Text(text = sede.tiempo, color = Color.Yellow, fontSize = 14.sp)
    }
}

@Preview
@Composable
private fun GoldsGymPreview() {
    GymSedePantalla(
        sedes = listOf(),
        brand = Brand("GERSON",R.drawable.brand_gold_gym)
    )
}