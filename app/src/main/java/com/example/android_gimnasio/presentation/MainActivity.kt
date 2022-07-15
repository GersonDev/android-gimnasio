package com.example.android_gimnasio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.components.BienvenidaPantalla
import com.example.android_gimnasio.presentation.components.RegistrarPantalla
import com.example.android_gimnasio.presentation.viewmodel.MenuViewModel
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class MainActivity : ComponentActivity() {

    val menuViewModel by viewModels<MenuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nombre by menuViewModel.nombre.observeAsState("")
            val correo by menuViewModel.correo.observeAsState("")
            val password by menuViewModel.password.observeAsState("")
            AndroidgimnasioTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.Logearse.route) {
                    composable(Screen.Logearse.route) {
                        BienvenidaPantalla(
                            onClickButtonRegistrar = {
                                navController.navigate(Screen.Registrar.route)
                            },
                            onClickButtonIncisiarSesion = {},
                            onClickButtonFacebook = {}
                        )
                    }
                    composable(Screen.Registrar.route) {
                        RegistrarPantalla(
                            onClickRegistro = {
                                menuViewModel.insertPeople(applicationContext)
                            },
                            onClickPrivacidad = {},
                            onClickCondiciones = {},
                            nombre = nombre,
                            correo = correo,
                            password = password,
                            onValueChangeNombre = {
                                menuViewModel.enviarNombre(it)
                            },
                            onValueChangeCorreo = {
                                menuViewModel.enviarCorreo(it)
                            },
                            onValueChangePassword = {
                                menuViewModel.enviarPassword(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

