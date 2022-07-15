package com.example.android_gimnasio.presentation

sealed class Screen(val route:String) {
    object Bienvenida:Screen("BienvenidaPantalla")
    object Registrar:Screen("registrarPantalla")
    object Login:Screen("loginPantalla")
}