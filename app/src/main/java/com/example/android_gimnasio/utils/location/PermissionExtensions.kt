package com.example.android_gimnasio.utils.location

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember

@Composable
fun checkSelfPermissionState(activity: ComponentActivity, permission: String): PermissionState {
    val key = "1"
    val call = remember(activity, permission) {
        PermissionResultCall(key, activity, permission)
    }

    DisposableEffect(
        key1 = call,
        effect = {
            call.initialCheck()
            onDispose {
                call.unregister()
            }
        })

    return call.checkSelfPermission()
}