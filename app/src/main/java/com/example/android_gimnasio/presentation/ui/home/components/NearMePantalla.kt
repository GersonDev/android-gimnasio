package com.example.android_gimnasio.presentation.ui.home.components

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.Bus
import com.example.android_gimnasio.domain.models.BusStop
import com.example.android_gimnasio.domain.models.MyCurrentLocation
import com.example.android_gimnasio.presentation.ui.home.HomeViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*
import com.google.maps.android.compose.Marker
import kotlinx.coroutines.launch

@Composable
fun NearMePantalla(
    homeViewModel: HomeViewModel,
    onBusSelected: (String) -> Unit
) {

    val busInfoList by homeViewModel.busInfoList.observeAsState(listOf())
    val currentBusStop by homeViewModel.currentBusStop.observeAsState(BusStop(0.0, 0.0, ""))
    val myCurrentLocation by homeViewModel.myCurrentLocation.observeAsState(homeViewModel.myCurrentLocationDefault)
    val coroutineScope = rememberCoroutineScope()

    BusInfoMapViewContainer(
        homeViewModel,
        myCurrentLocation,
        currentBusStop,
        busInfoList
    ) { busId ->
        coroutineScope.launch {
            onBusSelected(busId)
        }
    }
}

@SuppressLint("MissingPermission")
@Composable
fun BusInfoMapViewContainer(
    homeViewModel: HomeViewModel,
    myCurrentLocation: MyCurrentLocation,
    currentBusStop: BusStop,
    busInfoList: List<Bus>,
    onBusSelected: (String) -> Unit
) {
    val context = LocalContext.current

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(
                myCurrentLocation.latitude,
                myCurrentLocation.longitude
            ),
            15f
        )
    }

    // SIDE EFFECT IN COMPOSE
    LaunchedEffect(myCurrentLocation) {
        cameraPositionState.move(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    myCurrentLocation.latitude,
                    myCurrentLocation.longitude
                ), 15f
            )
        )
    }

    LaunchedEffect(cameraPositionState.isMoving) {
        val position = cameraPositionState.position
        val isMoving = cameraPositionState.isMoving

        if (!isMoving) {
            val myCurrentLocation =
                MyCurrentLocation(position.target.latitude, position.target.longitude)
            homeViewModel.setCameraPosition(myCurrentLocation)
            homeViewModel.setZoomLevel(cameraPositionState.position.zoom)
        }
    }


    val mapProperties by remember { mutableStateOf(MapProperties(isMyLocationEnabled = true)) }
    val uiSettings by remember { mutableStateOf(MapUiSettings(myLocationButtonEnabled = true)) }
    GoogleMap(
        cameraPositionState = cameraPositionState,
        properties = mapProperties, // SHOW THE LOCATION ICON, NEEDS COARSE, FINE LOCATION permission
        uiSettings = uiSettings // don't know yet, why do we need this, NEEDS COARSE, FINE LOCATION permission
    ) {
        currentBusStop.latitude?.let { latitude ->
            currentBusStop.longitude?.let { longitude ->
                val busStopLocation = LatLng(latitude, longitude)
                val icon =
                    bitmapDescriptorFromVector(context, R.drawable.ic_stop, R.color.mapMarkerGreen)
                Marker(
                    state = MarkerState(position = busStopLocation),
                    title = currentBusStop.shortName,
                    icon = icon,
                    tag = currentBusStop
                )
            }
        }

        // bus markers
        for (bus in busInfoList) {
            val busLocation = LatLng(bus.latitude, bus.longitude)

            val tintColor = if (bus.direction == 1) {
                R.color.direction1
            } else {
                R.color.direction2
            }

            val title = if (bus.departure_metadata != null) {
                bus.departure_metadata?.destination
            } else {
                bus.vehicle_id
            }

            val snippet = if (bus.departure_metadata != null) {
                val delayMins = bus.departure_metadata?.delay?.div(60) ?: 0
                "Delay: $delayMins ${
                    context.resources.getQuantityString(
                        R.plurals.mins,
                        delayMins
                    )
                }"
            } else {
                ""
            }

            val icon = bitmapDescriptorFromVector(context, bus.imagen /*tintColor*/)
            MarkerInfoWindowContent(
                state = MarkerState(
                    position = busLocation
                ),
                title = title,
                snippet = snippet,
                icon = icon,
                tag = bus,
                onInfoWindowClick = {
                    onBusSelected(bus.vehicle_id)
                }
            ) { marker ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(marker.title!!)
                    Text(marker.snippet!!)
                }
            }
        }
    }
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int,
    @ColorRes tintColor: Int? = null
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // add the tint if it exists
    tintColor?.let {
        DrawableCompat.setTint(drawable, ContextCompat.getColor(context, it))
    }
    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}


@Preview
@Composable
private fun NearMePantallaPreview() {
    NearMePantalla(
        homeViewModel = HomeViewModel(application = Application()),
        onBusSelected = {}
    )
}