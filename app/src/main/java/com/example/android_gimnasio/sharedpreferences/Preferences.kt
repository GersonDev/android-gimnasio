package com.example.android_gimnasio.sharedpreferences

import android.content.Context

class Preferences(val context: Context) {

   private val SHARED_PREFERENCES_NAME:String = "Preferencias_de_Gerson"
   private val USER_ID_KEY:String = "USER_ID"

   private val storage = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0)

    fun saveId(id: Int) {
        storage.edit().putInt(USER_ID_KEY, id).apply()
    }

    fun getId(): Int {
        return storage.getInt(USER_ID_KEY, 0)
    }
}