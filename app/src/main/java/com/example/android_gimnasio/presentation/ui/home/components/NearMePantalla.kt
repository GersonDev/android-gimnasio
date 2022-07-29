package com.example.android_gimnasio.presentation.ui.home.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.Bus
import com.example.android_gimnasio.domain.models.BusStop
import com.example.android_gimnasio.presentation.viewmodel.HomeViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*
import com.google.maps.android.compose.Marker
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun NearMePantalla(
    homeViewModel: HomeViewModel,
    onBusSelected: (String) -> Unit
) {

//    val markerPosition = LatLng(-11.967750655284977, -77.00428152896053)
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(markerPosition, 15f)
//    }

    val busInfoList by homeViewModel.busInfoList.observeAsState(listOf())
    val currentBusStop by homeViewModel.currentBusStop.observeAsState(BusStop(0.0, 0.0, ""))
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
            .padding(bottom = 60.dp)
    ) {
        BusInfoMapViewContainer(currentBusStop, busInfoList) { busId ->
            coroutineScope.launch {
                onBusSelected(busId)
            }
        }
    }
}

@SuppressLint("MissingPermission")
@Composable
fun BusInfoMapViewContainer(
    stop: BusStop,
    busInfoList: List<Bus>,
    onBusSelected: (String) -> Unit
) {
    val context = LocalContext.current

    val cameraPositionState = rememberCameraPositionState()

    // SIDE EFFECT IN COMPOSE
    LaunchedEffect(stop) {
        val builder = LatLngBounds.Builder()

        stop.latitude?.let { latitude ->
            stop.longitude?.let { longitude ->
                val busStopLocation = LatLng(latitude, longitude)
                builder.include(busStopLocation)
            }
        }

        busInfoList.forEach { bus ->
            val busLocation = LatLng(bus.latitude, bus.longitude)
            builder.include(busLocation)
        }

        cameraPositionState.move(CameraUpdateFactory.newLatLngBounds(builder.build(), 64))
    }


    val mapProperties by remember { mutableStateOf(MapProperties(isMyLocationEnabled = true)) }
    val uiSettings by remember { mutableStateOf(MapUiSettings(myLocationButtonEnabled = true)) }
    GoogleMap(
        cameraPositionState = cameraPositionState,
//        properties = mapProperties, // COARSE, FINE LOCATION
//        uiSettings = uiSettings // COARSE, FINE LOCATION
    ) {
        stop.latitude?.let { latitude ->
            stop.longitude?.let { longitude ->
                val busStopLocation = LatLng(latitude, longitude)
                val icon =
                    bitmapDescriptorFromVector(context, R.drawable.ic_stop, R.color.mapMarkerGreen)
                Marker(
                    state = MarkerState(position = busStopLocation),
                    title = stop.shortName,
                    icon = icon,
                    tag = stop
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

            val icon = bitmapDescriptorFromVector(context, R.drawable.bus_side, tintColor)
            MarkerInfoWindowContent(
                state = MarkerState(position = busLocation), title = title,
                snippet = snippet, icon = icon, tag = bus,
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
        homeViewModel = HomeViewModel(),
        onBusSelected = {}
    )
}