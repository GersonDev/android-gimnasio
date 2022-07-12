package com.example.android_gimnasio.presentation

sealed class Screen(val route:String) {
    object Logearse:Screen("logearsePantalla")
    object Registrar:Screen("registrarPantalla")
}