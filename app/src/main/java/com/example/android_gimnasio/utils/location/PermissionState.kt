package com.example.android_gimnasio.utils.location

import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LiveData

class PermissionState(
    private val permission: String,
    val hasPermission: LiveData<Boolean>,
    private val launcher: ActivityResultLauncher<String>
) {
    fun launchPermissionRequest() {
        return launcher.launch(permission)
    }
}