package com.example.android_gimnasio.presentation.ui.welcome

import android.app.DownloadManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.routes.WelcomeScreen
import com.example.android_gimnasio.presentation.ui.welcome.components.*
import com.example.android_gimnasio.presentation.ui.home.HomeActivity
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme
import com.example.android_gimnasio.utils.CheckDownloadCompleteBroadcastReceiver
import com.example.android_gimnasio.utils.Repoo

class WelcomeActivity : ComponentActivity() {

    private lateinit var checkDownloadCompleteBroadcastReceiver: CheckDownloadCompleteBroadcastReceiver

    private val welcomeViewModel by viewModels<WelcomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkDownloadCompleteBroadcastReceiver = CheckDownloadCompleteBroadcastReceiver()

        setContent {
            AndroidgimnasioTheme {
                MainScreen(
                    welcomeViewModel
                )

                val carlos = Repoo.mData.observeAsState()

                carlos.value?.let {
                    Text("carlosssssssss $it")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        filter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED)
        registerReceiver(checkDownloadCompleteBroadcastReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(checkDownloadCompleteBroadcastReceiver)
    }

}

@Composable
fun MainScreen(
    welcomeViewModel: WelcomeViewModel
) {
    val correo by welcomeViewModel.email.observeAsState("")
    val password by welcomeViewModel.password.observeAsState("")
    val confirmationPassword by welcomeViewModel.confirmationPassword.observeAsState("")
    val registroExitoso by welcomeViewModel.registroExitoso.observeAsState(false)
    val loginExitoso by welcomeViewModel.loginExitoso.observeAsState()
    val isLogin by welcomeViewModel.isLogin.observeAsState(false)
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = WelcomeScreen.Bienvenida.route) {

        composable(WelcomeScreen.Bienvenida.route) {
            welcomeViewModel.verifyLogin(context)
            WelcomePantalla(
                onClickStarted = {
//                  welcomeViewModel.downloadFile(context)
                    navController.navigate(WelcomeScreen.Login.route)
                },
            )
            if (isLogin) {
                context.startActivity(Intent(context, HomeActivity::class.java))
            }
        }
        composable(WelcomeScreen.Login.route) {
            LoginPantalla(
                onClickLoginPantalla = {
                    welcomeViewModel.startLogin(context)
                },
                correo = correo,
                password = password,
                onValueChangeCorreo = {
                    welcomeViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    welcomeViewModel.enviarPassword(it)
                },
                onClickSignUp = {
                    navController.navigate(WelcomeScreen.Registrar.route)
                }
            )
            when (loginExitoso) {
                null -> {

                }
                true -> {
                    context.startActivity(Intent(context, HomeActivity::class.java))
                }
                false -> {
                    ModalDeError {
                        welcomeViewModel.ocultarModal()
                    }
                }
            }
        }
        composable(WelcomeScreen.Registrar.route) {
            RegistrarPantalla(
                onClickRegistro = {
                    welcomeViewModel.insertPeople(context)
                },
                email = correo,
                password = password,
                confirmationPassword = confirmationPassword,
                onValueChangeEmail = {
                    welcomeViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    welcomeViewModel.enviarPassword(it)
                },
                onValueChangeConfirmationPassword = {
                    welcomeViewModel.enviarConfirmationPassword(it)
                },
                onClickSignIn = {
                    navController.navigate(WelcomeScreen.Login.route)
                }

            )
            if (registroExitoso) {
                context.startActivity(Intent(context, HomeActivity::class.java))
            }

        }
    }
}
