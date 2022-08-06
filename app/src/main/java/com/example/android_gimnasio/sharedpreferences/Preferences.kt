package com.example.android_gimnasio.sharedpreferences

import android.content.Context

class Preferences(val context: Context) {

    val USER_ID: Int = 0

    val storage = context.getSharedPreferences(USER_ID.toString(), 0)

    fun saveId(id: Int) {
        storage.edit().putString(USER_ID.toString(), id.toString()).apply()
    }

    fun getId(): Int {
        return storage.getInt(USER_ID.toString(), 0)
    }
}