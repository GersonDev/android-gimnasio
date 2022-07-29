package com.example.android_gimnasio.domain.models

data class Bus(
    val vehicle_id: String,
    val latitude: Double,
    val longitude: Double,
    val direction: Int = 0,
    val departure_metadata: DepartureMetadata? = null
)

data class DepartureMetadata(val destination: String, val delay: Int)