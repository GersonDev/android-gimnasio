package com.example.android_gimnasio.utils.location

import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData

class PermissionResultCall(
    key: String,
    private val activity: ComponentActivity,
    private val permission: String
) {

    private val _hasPermission = MutableLiveData(false)

    private val call = activity.activityResultRegistry.register(
        "LocationPermissions#($key)",
        ActivityResultContracts.RequestPermission()
    ) { result ->
        onPermissionResult(result)
    }

    fun initialCheck() {
        _hasPermission.value = checkPermission()
    }

    fun unregister() {
        call.unregister()
    }

    fun checkSelfPermission(): PermissionState {
        return PermissionState(permission, _hasPermission, call)
    }

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun onPermissionResult(result: Boolean) {
        _hasPermission.value = result
    }

}