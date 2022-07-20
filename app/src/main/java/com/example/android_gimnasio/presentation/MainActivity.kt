package com.example.android_gimnasio.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.components.*
import com.example.android_gimnasio.presentation.main.PrincipalActivity
import com.example.android_gimnasio.presentation.viewmodel.MainViewModel
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidgimnasioTheme {
                MainScreen(
                    mainViewModel
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val nombre by mainViewModel.nombre.observeAsState("")
    val correo by mainViewModel.correo.observeAsState("")
    val password by mainViewModel.password.observeAsState("")
    val registroExitoso by mainViewModel.registroExitoso.observeAsState(false)
    val loginExitoso by mainViewModel.loginExitoso.observeAsState()
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Bienvenida.route) {
        composable(Screen.Bienvenida.route) {
            WelcomePantalla()

//            BienvenidaPantalla(
//                onClickButtonRegistrar = {
//                    navController.navigate(Screen.Registrar.route)
//                },
//                onClickButtonIncisiarSesion = {
//                    navController.navigate(Screen.Login.route)
//                },
//                onClickButtonFacebook = {}
//            )
        }
        composable(Screen.Registrar.route) {
            RegistrarPantalla(
                onClickRegistro = {
                    mainViewModel.insertPeople(context)
                },
                onClickPrivacidad = {},
                onClickCondiciones = {},
                nombre = nombre,
                correo = correo,
                password = password,
                onValueChangeNombre = {
                    mainViewModel.enviarNombre(it)
                },
                onValueChangeCorreo = {
                    mainViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    mainViewModel.enviarPassword(it)
                }
            )
            if (registroExitoso) {
                context.startActivity(Intent(context, PrincipalActivity::class.java))
            }

        }
        composable(Screen.Login.route) {
            LoginPantalla(
                onClickLoginPantalla = {
                    mainViewModel.startLogin(context)
                },
                correo = correo,
                password = password,
                onValueChangeCorreo = {
                    mainViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    mainViewModel.enviarPassword(it)
                }
            )
            when (loginExitoso) {
                null -> {

                }
                true -> {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
                }
                false -> {
                    ModalDeError {
                        mainViewModel.ocultarModal()
                    }
                }
            }
        }
    }
}
