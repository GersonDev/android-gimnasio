package com.example.android_gimnasio.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_gimnasio.presentation.ui.welcome.WelcomeActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash_screen)

        startActivity(Intent(this@SplashScreenActivity, WelcomeActivity::class.java))
        finish()

    }
}