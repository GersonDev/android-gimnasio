package com.example.android_gimnasio.presentation.routes

sealed class MatricularseScreen(val route:String) {
    object GymSedeDetail:MatricularseScreen("GymSedeDetailPantalla")
}