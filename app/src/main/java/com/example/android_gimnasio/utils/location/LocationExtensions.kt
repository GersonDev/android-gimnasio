package com.example.android_gimnasio.utils.location

import androidx.activity.ComponentActivity
import com.example.android_gimnasio.utils.location.FusedLocationWrapper
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun ComponentActivity.fusedLocationWrapper(): FusedLocationWrapper {
    return FusedLocationWrapper(LocationServices.getFusedLocationProviderClient(this))
}