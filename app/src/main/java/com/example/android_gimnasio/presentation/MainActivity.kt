package com.example.android_gimnasio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.components.LogearsePantalla
import com.example.android_gimnasio.presentation.components.RegistrarPantalla
import com.example.android_gimnasio.presentation.viewmodel.MenuViewModel
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class MainActivity : ComponentActivity() {
    val menuViewModel by viewModels<MenuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidgimnasioTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.Logearse.route) {
                    composable(Screen.Logearse.route) {
                        LogearsePantalla(
                            onClickButtonOne = {
                                navController.navigate(Screen.Registrar.route)
                            },
                            onClickButtonTwo = {},
                            onClickButtonThree = {}
                        )
                    }
                    composable(Screen.Registrar.route) {
                        RegistrarPantalla(
                            onClickRegistro = {

                                              },
                            onClickPrivacidad = {},
                            onClickCondiciones = {},
                            nombre = "",
                            correo = "",
                            contraseña = ""
                        )
                    }
                }
            }
        }
    }
}

