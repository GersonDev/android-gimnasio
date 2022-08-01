package com.example.android_gimnasio.presentation.routes

import com.example.android_gimnasio.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Home: BottomNavItem("Home", R.drawable.ic_home_64, "home")
    object Gym: BottomNavItem("Gym", R.drawable.ic_gym_64, "gym")
    object NearMe: BottomNavItem("Cerca a Mí", R.drawable.ic_gps_64, "cerca a mí")
    object Trainer: BottomNavItem("Trainer", R.drawable.ic_trainer_64, "trainer")
    object Profile: BottomNavItem("Profile", R.drawable.ic_profile_64, "profile")
    object GymSedes: BottomNavItem("GymSedes", R.drawable.ic_baseline_home_24, "proba")
}