package com.example.android_gimnasio.presentation.ui.gym_sedes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Brand
import com.example.android_gimnasio.domain.models.gym.Sede
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class GymSedesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.intent.extras
        val tituloDeMarca = bundle?.getString("MARCA_TITULO")
        val imagenDeMarca = bundle?.getInt("MARCA_IMAGEN")
        setContent {
            AndroidgimnasioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    when(tituloDeMarca){
                        "Gold's Gym"->{
                            GymSedePantalla(
                                sedes = listOf(
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.golds_gimnasio,
                                        "Gold´S GYM \n San Borja",
                                        "Av. Javier Prado Este 1980 \n- Lima, Lima - 15036",
                                        "6am - 11pm"
                                    )
                                ),
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Megaforce"->{
                            GymSedePantalla(
                                sedes = listOf(
                                    Sede(
                                        R.drawable.megaforce_mariscal,
                                        "MEGAFORCE \n Mariscal Caceres",
                                        "Av.Fernando Wiesse Mz.M15 Lt.34\n San Juan de Lurigancho",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.megaforce_santarosa,
                                        "MEGAFORCE \n Santa Rosa",
                                        "Av. Fernando Wiesse\n Cercado de Lima 15079",
                                        "6am - 10:30pm"
                                    ),
                                    Sede(
                                        R.drawable.megaforce_hacienda,
                                        "MEGAFORCE \n Hacienda",
                                        "Av. Próceres de la Independencia 1715\n San Juan de Lurigancho 36",
                                        "6am - 10:30pm"
                                    ),
                                    Sede(
                                        R.drawable.megaforce_losolivos,
                                        "MEGAFORCE \n LOS OLIVOS",
                                        "Av. Naranjal 1542\n Los Olivos 15306",
                                        "6am - 11pm"
                                    ),
                                    Sede(
                                        R.drawable.mega_force_ate,
                                        "MEGAFORCE \n Ate",
                                        "Av. Nicolas Ayllon 5596\n Ate, Municipalidad de Lima",
                                        "6am - 10:30pm"
                                    ),
                                    Sede(
                                        R.drawable.megaforce_ventanilla,
                                        "MEGAFORCE \n Ventanilla Metro",
                                        "Av. Ventanilla Mz. C8 Lot. 16\n Ventanilla CALLAO ",
                                        "6am - 11pm"
                                    )
                                ),
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "SmartFit"->{
                            GymSedePantalla(
                                sedes = listOf(
                                    Sede(
                                        R.drawable.smartfit_benavides,
                                        "Smart Fit \n Benavides",
                                        "Av.Alfredo Benavides 347 Miraflores\n Municipalidad de Lima",
                                        "6am-11pm"
                                    ),
                                    Sede(
                                        R.drawable.smartfit_higuereta,
                                        "Smart Fit \n Higuereta",
                                        "Av. Aviación con Av. Tomás Marsano\n Santiago de Surco 15038",
                                        "6am-11pm"
                                    ),
                                    Sede(
                                        R.drawable.smartfit_colonial,
                                        "Smart Fit \n Colonial",
                                        "Av. Óscar R. Benavides 669\n Cercado de Lima 15082",
                                        "6am-11pm"
                                    ),
                                    Sede(
                                        R.drawable.smartfit_sanborja,
                                        "Smart Fit \n San Borja",
                                        "Av. Javier Prado Este 1980\n San Borja 15036",
                                        "6am-11pm"
                                    ),
                                    Sede(
                                        R.drawable.smartfit_megaplaza,
                                        "Smart Fit \n Mega Plaza Lima Norte",
                                        "Av. Alfredo Mendiola 3698\n Independencia 15311",
                                        "6am-11pm"
                                    )
                                ),
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Bodytech"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Megatlon"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Gimnasio B2"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Aldo's Gym"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "X Sport Gym"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Master Gym"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Fitness de Impacto"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                        "Sportlife Fitness Club"->{
                            GymSedePantalla(
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
                                brand = Brand(tituloDeMarca!!, imagenDeMarca!!)
                            )
                        }
                    }

                }
            }

        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AndroidgimnasioTheme {
        Greeting("Android")
    }
}