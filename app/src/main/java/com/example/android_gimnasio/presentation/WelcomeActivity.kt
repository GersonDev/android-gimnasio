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

class WelcomeActivity : ComponentActivity() {

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
    val correo by mainViewModel.email.observeAsState("")
    val password by mainViewModel.password.observeAsState("")
    val confirmationPassword by mainViewModel.confirmationPassword.observeAsState("")
    val registroExitoso by mainViewModel.registroExitoso.observeAsState(false)
    val loginExitoso by mainViewModel.loginExitoso.observeAsState()
    val isLogin by mainViewModel.isLogin.observeAsState(false)
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Bienvenida.route) {

        composable(Screen.Bienvenida.route) {
            mainViewModel.verifyLogin(context)
            WelcomePantalla(
                onClickStarted = {
                    navController.navigate(Screen.Login.route)
                },
            )
            if (isLogin) {
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
                },
                onClickSignUp = {
                    navController.navigate(Screen.Registrar.route)
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
        composable(Screen.Registrar.route) {
            RegistrarPantalla(
                onClickRegistro = {
                    mainViewModel.insertPeople(context)
                },
                email = correo,
                password = password,
                confirmationPassword = confirmationPassword,
                onValueChangeEmail = {
                    mainViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    mainViewModel.enviarPassword(it)
                },
                onValueChangeConfirmationPassword = {
                    mainViewModel.enviarConfirmationPassword(it)
                },
                onClickSignIn = {
                    navController.navigate(Screen.Login.route)
                }

            )
            if (registroExitoso) {
                context.startActivity(Intent(context, PrincipalActivity::class.java))
            }

        }
    }
}
