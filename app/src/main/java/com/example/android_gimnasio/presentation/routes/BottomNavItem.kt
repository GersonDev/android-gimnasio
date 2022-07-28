package com.example.android_gimnasio.presentation.routes

import com.example.android_gimnasio.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home: BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object Gym: BottomNavItem("Gym", R.drawable.ic_baseline_adb_24, "gym")
    object NearMe: BottomNavItem("Cerca a Mí", R.drawable.ic_baseline_home_24, "cerca a mí")
    object Trainer: BottomNavItem("Trainer", R.drawable.ic_baseline_home_24, "trainer")
    object Profile: BottomNavItem("Profile", R.drawable.ic_baseline_account_circle_24, "profile")
    object Cuenta: BottomNavItem("Cuenta", R.drawable.ic_baseline_home_24, "cuenta")
    object Proba: BottomNavItem("Proba", R.drawable.ic_baseline_home_24, "proba")
}