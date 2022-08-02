package com.example.android_gimnasio.presentation.routes

import com.example.android_gimnasio.R

sealed class BottomNavItem(var title: Int, var icon: Int, var screenRoute: String) {
    object Home: BottomNavItem(R.string.home, R.drawable.ic_home_64, "home")
    object Gym: BottomNavItem(R.string.gym, R.drawable.ic_gym_64, "gym")
    object NearMe: BottomNavItem(R.string.nearme, R.drawable.ic_gps_64, "cerca a mí")
    object Trainer: BottomNavItem(R.string.trainer, R.drawable.ic_trainer_64, "trainer")
    object Profile: BottomNavItem(R.string.profile, R.drawable.ic_profile_64, "profile")
    object GymSedes: BottomNavItem(R.string.gymsedes, R.drawable.ic_baseline_home_24, "proba")
}