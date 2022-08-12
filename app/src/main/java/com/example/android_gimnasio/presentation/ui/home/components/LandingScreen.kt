package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android_gimnasio.presentation.ui.home.HomeViewModel
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(
    homeViewModel: HomeViewModel,
    onTimeout: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val currentOnTimeout by rememberUpdatedState(onTimeout)

        LaunchedEffect(true) {
            // here you can fetch something in the viewModel (for example: fetch  and store users, etc)
            delay(SplashWaitTime)
            currentOnTimeout()
        }

        Text("LOADING...")
    }
}

private const val SplashWaitTime: Long = 1000