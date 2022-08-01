package com.example.android_gimnasio.presentation.ui.home.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Sede
import com.example.android_gimnasio.presentation.common.components.GymTitle

@Composable
fun GymSedesPantalla(tituloDeMarca: String, imagenDeMarca: Int, onClickSede: (Sede) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.trainers__primary))
            .padding(start = 10.dp, bottom = 20.dp, top = 20.dp, end = 3.dp)
    ) {
        GymTitle(tituloDeMarca, imagenDeMarca, ocultarImagen = true)
        when (tituloDeMarca) {
            "Gold's Gym" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.golds_gimnasio,
                            "Gold´S GYM \n San Borja",
                            "Av. Javier Prado Este 1980 - Lima, Lima - 15036",
                            "6am - 11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Megaforce" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.megaforce_mariscal,
                            "MEGAFORCE \n Mariscal Caceres",
                            "Av.Fernando Wiesse Mz.M15 Lt.34 San Juan de Lurigancho",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.megaforce_santarosa,
                            "MEGAFORCE \n Santa Rosa",
                            "Av. Fernando Wiesse Cercado de Lima 15079",
                            "6am - 10:30pm"
                        ),
                        Sede(
                            R.drawable.megaforce_hacienda,
                            "MEGAFORCE \n Hacienda",
                            "Av. Próceres de la Independencia 1715 San Juan de Lurigancho 36",
                            "6am - 10:30pm"
                        ),
                        Sede(
                            R.drawable.megaforce_losolivos,
                            "MEGAFORCE \n LOS OLIVOS",
                            "Av. Naranjal 1542 Los Olivos 15306",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.mega_force_ate,
                            "MEGAFORCE \n Ate",
                            "Av. Nicolas Ayllon 5596 Ate, Municipalidad de Lima",
                            "6am - 10:30pm"
                        ),
                        Sede(
                            R.drawable.megaforce_ventanilla,
                            "MEGAFORCE \n Ventanilla Metro",
                            "Av. Ventanilla Mz. C8 Lot. 16 Ventanilla CALLAO ",
                            "6am - 11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "SmartFit" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.smartfit_benavides,
                            "Smart Fit \n Benavides",
                            "Av.Alfredo Benavides 347 Miraflores Municipalidad de Lima",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.smartfit_higuereta,
                            "Smart Fit \n Higuereta",
                            "Av. Aviación con Av. Tomás Marsano Santiago de Surco 15038",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.smartfit_colonial,
                            "Smart Fit \n Colonial",
                            "Av. Óscar R. Benavides 669 Cercado de Lima 15082",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.smartfit_sanborja,
                            "Smart Fit \n San Borja",
                            "Av. Javier Prado Este 1980 San Borja 15036",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.smartfit_megaplaza,
                            "Smart Fit \n Mega Plaza Lima Norte",
                            "Av. Alfredo Mendiola 3698 Independencia 15311",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Bodytech" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999\n Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE\n San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855\n Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220\n Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599\n Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Megatlon" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999 Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855 Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220 Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599 Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Gimnasio B2" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999 Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855 Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220 Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599 Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Aldo's Gym" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999 Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855 Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220 Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599 Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "X Sport Gym" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999\n Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE\n San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855\n Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220\n Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599\n Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Master Gym" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999\n Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE\n San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855\n Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220\n Cercado de Lima 15024",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599\n Jesús María 15072",
                            "6am-11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Fitness de Impacto" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999\n Magdalena del Mar 15076",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE\n San Miguel",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855\n Miraflores 15074",
                            "6am-11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220\n Cercado de Lima 15024",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599\n Jesús María 15072",
                            "6am - 11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
            "Sportlife Fitness Club" -> {
                GymSedesComponent(
                    sedes = listOf(
                        Sede(
                            R.drawable.bodytech_magdalena,
                            "Bodytech \n Magdalena",
                            "Av Javier Prado Oeste 999\n Magdalena del Mar 15076",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_sanmiguel,
                            "Bodytech \n San Miguel",
                            "ESQUINA DE AV.LA MAR CON UNIVERSITARIA, PE\n San Miguel",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_miraflores,
                            "Bodytech \n Miraflores",
                            "Av. Sta. Cruz 855\n Miraflores 15074",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_ceradodelima,
                            "Bodytech \n Cercado de Lima",
                            "Av. Javier Prado Este 6220\n Cercado de Lima 15024",
                            "6am - 11pm"
                        ),
                        Sede(
                            R.drawable.bodytech_jesusmaria,
                            "Bodytech \n Jesus Maria",
                            "Plaza Vea Brasil, Av. Brasil 1599\n Jesús María 15072",
                            "6am - 11pm"
                        )
                    ),
                    onClickSede = onClickSede
                )
            }
        }
    }
}

@Composable
private fun GymSedesComponent(sedes: List<Sede>, onClickSede: (Sede) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            sedes.forEach {
                GymSedeCelda(it) {
                    onClickSede(it)
                    Log.e("CARLOS", "VALOR $it")
                }
            }
        }
    }
}

@Composable
private fun GymSedeCelda(
    sede: Sede,
    onClickCell: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClickCell()
            },
        verticalAlignment = Alignment.CenterVertically
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = sede.titulo, color = Color.White, fontSize = 20.sp, modifier = Modifier.weight(1f))
                Text(
                    text = sede.tiempo,
                    color = Color.Yellow,
                    fontSize = 13.sp
                )
            }
            Text(
                text = sede.descripcion,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Preview
@Composable
private fun GoldsGymPreview() {
    GymSedesComponent(
        sedes = listOf(),
        onClickSede = {}
    )
}