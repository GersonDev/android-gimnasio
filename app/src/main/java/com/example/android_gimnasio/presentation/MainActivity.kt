package com.example.android_gimnasio.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.components.LogearsePantalla
import com.example.android_gimnasio.presentation.main.PrincipalActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Logearse.route) {
        composable(Screen.Logearse.route) {
            LogearsePantalla(
                onClickButtonOne = {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
//                            navController.navigate(Screen.Registrar.route)
                },
                onClickButtonTwo = {},
                onClickButtonThree = {}
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}

