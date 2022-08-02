package com.example.android_gimnasio.presentation.ui.matricula.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.presentation.common.components.GymTitle

@Composable
fun GymSedeDetailPantalla(
    marcaDeSede: String, onClickMatricularse: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.trainers_primary)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.golds_gimnasio),
                contentDescription = "Imagen de Golds Gym",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                "Somos una cadena de Gimnasios peruana con 15 años impulsando un estilo " +
                        "de vida saludable en las familias, ahora mediante de esta plataforma digital " +
                        "podrás disfrutar de la experiencia Mega Force que combina las mejores clases grupales online, " +
                        "asesoramiento personalizado, nutrición y mucho más que permitirá que muchas personas vivan una  " +
                        "experiencia única alrededor del mundo.",
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
            Text(
                "Somos una cadena de Gimnasios peruana con 15 años impulsando un estilo " +
                        "de vida saludable en las familias, ahora mediante de esta plataforma digital " +
                        "podrás disfrutar de la experiencia Mega Force que combina las mejores clases grupales online, " +
                        "asesoramiento personalizado, nutrición y mucho más que permitirá que muchas personas vivan una  " +
                        "experiencia única alrededor del mundo.",
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
            Text(
                "Somos una cadena de Gimnasios peruana con 15 años impulsando un estilo " +
                        "de vida saludable en las familias, ahora mediante de esta plataforma digital " +
                        "podrás disfrutar de la experiencia Mega Force que combina las mejores clases grupales online, " +
                        "asesoramiento personalizado, nutrición y mucho más que permitirá que muchas personas vivan una  " +
                        "experiencia única alrededor del mundo.",
                color = Color.White,
                style = MaterialTheme.typography.body2
            )

        }
        Column {
            GymTitle(marcaDeSede, R.drawable.img_user_profile)
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = onClickMatricularse,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("Matricularse")
            }
        }
    }
}

@Composable
private fun GymSedeDetailPantallaPreview() {
    GymSedeDetailPantalla("Gym", onClickMatricularse = {})
}