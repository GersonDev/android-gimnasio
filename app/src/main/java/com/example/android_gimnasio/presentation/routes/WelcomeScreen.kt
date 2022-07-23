package com.example.android_gimnasio.presentation.routes

sealed class WelcomeScreen(val route:String) {
    object Bienvenida: WelcomeScreen("BienvenidaPantalla")
    object Registrar: WelcomeScreen("registrarPantalla")
    object Login: WelcomeScreen("loginPantalla")
}

