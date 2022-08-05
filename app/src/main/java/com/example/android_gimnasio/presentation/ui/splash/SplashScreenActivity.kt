package com.example.android_gimnasio.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.android_gimnasio.presentation.ui.welcome.WelcomeActivity

class SplashScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this@SplashScreenActivity, WelcomeActivity::class.java))
        finish()
    }
}