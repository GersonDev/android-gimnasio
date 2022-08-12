package com.example.android_gimnasio.utils.location

import android.Manifest
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

@ExperimentalCoroutinesApi
class FusedLocationWrapper(
    private val fusedLocation: FusedLocationProviderClient
) {

    @RequiresPermission(anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    suspend fun awaitLastLocation(): Location {
        return suspendCancellableCoroutine { continuation ->
            fusedLocation.lastLocation.addOnSuccessListener { location ->
                if(location != null) {
                    continuation.resume(location, onCancellation = {})
                }
            }.addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }
        }
    }

}