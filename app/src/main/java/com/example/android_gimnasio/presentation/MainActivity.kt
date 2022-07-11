package com.example.android_gimnasio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.components.LogearsePantalla
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.Logearse.route) {
                composable(Screen.Logearse.route) {
                    LogearsePantalla(

                    )
                }
            }
        }
    }
}

