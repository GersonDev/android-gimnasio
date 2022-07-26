package com.example.android_gimnasio.presentation.ui.gym_sedes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Sede
import com.example.android_gimnasio.presentation.common.components.GymTitle
import com.example.android_gimnasio.presentation.ui.home.components.SectionTitle


@Composable
fun GoldsGym(sedes: List<Sede>) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.trainers__primary))
            .padding(start = 10.dp, bottom = 60.dp, top = 60.dp)
    ) {

        GymTitle("Notifications", R.drawable.brand_gold_gym)

        Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = androidx.compose.ui.Modifier
                .padding(start = 30.dp)

        )
        {
            Text("Today", color = Color.White, fontSize = 20.sp)
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            sedes.forEach {
                CeldaDeSedesGimnasio(it)
            }
        }


    }
}

@Composable
fun CeldaDeSedesGimnasio(
    sede:Sede
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(1.dp)
        ) {
        }
        Image(
            painter = painterResource(id = sede.imagen),
            contentDescription = "Imagen de Golds Gym",
            modifier = Modifier
                .clip(shape = RoundedCornerShape(35.dp))
                .size(100.dp)
            )
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
    GoldsGym(listOf())
}