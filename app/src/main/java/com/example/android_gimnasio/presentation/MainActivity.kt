package com.example.android_gimnasio.presentation

import android.content.Context
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
import com.example.android_gimnasio.presentation.components.BienvenidaPantalla
import com.example.android_gimnasio.presentation.components.LoginPantalla
import com.example.android_gimnasio.presentation.components.RegistrarPantalla
import com.example.android_gimnasio.presentation.main.PrincipalActivity
import com.example.android_gimnasio.presentation.viewmodel.LoginViewModel
import com.example.android_gimnasio.presentation.viewmodel.RegistrarViewModel
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class MainActivity : ComponentActivity() {

    private val registrarViewModel by viewModels<RegistrarViewModel>()
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidgimnasioTheme {
                MainScreen(
                    applicationContext,
                    registrarViewModel,
                    loginViewModel
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    applicationContext: Context,
    registrarViewModel: RegistrarViewModel,
    loginViewModel: LoginViewModel
) {
    val nombre by registrarViewModel.nombre.observeAsState("")
    val correo by registrarViewModel.correo.observeAsState("")
    val password by registrarViewModel.password.observeAsState("")
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Bienvenida.route) {
        composable(Screen.Bienvenida.route) {
            BienvenidaPantalla(
                onClickButtonRegistrar = {
                    navController.navigate(Screen.Registrar.route)
                },
                onClickButtonIncisiarSesion = {
                    navController.navigate(Screen.Login.route)
                },
                onClickButtonFacebook = {}
            )
        }
        composable(Screen.Registrar.route) {
            RegistrarPantalla(
                onClickRegistro = {
                    registrarViewModel.insertPeople(applicationContext)
                },
                onClickPrivacidad = {},
                onClickCondiciones = {},
                nombre = nombre,
                correo = correo,
                password = password,
                onValueChangeNombre = {
                    registrarViewModel.enviarNombre(it)
                },
                onValueChangeCorreo = {
                    registrarViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    registrarViewModel.enviarPassword(it)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginPantalla(
                onClickLoginPantalla = {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
                },
                correo = "",
                password = "",
                onValueChangeCorreo = {},
                onValueChangePassword = {}
            )
        }
    }
}
