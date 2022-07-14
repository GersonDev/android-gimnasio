package com.example.android_gimnasio.presentation

import com.example.android_gimnasio.R

sealed class Screen(val route:String) {
    object Logearse:Screen("logearsePantalla")
    object Registrar:Screen("registrarPantalla")
}

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home: BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object Gym: BottomNavItem("Gym", R.drawable.ic_baseline_adb_24, "gym")
    object Baile: BottomNavItem("Baile", R.drawable.ic_baseline_home_24, "baile")
    object Trainer: BottomNavItem("Trainer", R.drawable.ic_baseline_home_24, "trainer")
    object Parque: BottomNavItem("Parque", R.drawable.ic_baseline_home_24, "parque")
    object Cuenta: BottomNavItem("Cuenta", R.drawable.ic_baseline_home_24, "cuenta")
}