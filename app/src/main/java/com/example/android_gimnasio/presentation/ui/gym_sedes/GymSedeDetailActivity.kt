package com.example.android_gimnasio.presentation.ui.gym_sedes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.R
import com.example.android_gimnasio.presentation.common.components.GymTitle
import com.example.android_gimnasio.presentation.ui.gym_sedes.components.GymSedeDetailPantalla
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class GymSedeDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.intent.extras
        val tituloDeMarca = bundle?.getString("MARCA_TITULO")
        val imagenDeMarca = bundle?.getInt("MARCA_IMAGEN")
        setContent {
            AndroidgimnasioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GymSedeDetailScreen()
                }
            }
        }
    }
}

@Composable
private fun GymSedeDetailScreen() {
    val navController = rememberNavController()
    GymSedeDetailPantalla()
}

@Preview(showBackground = true)
@Composable
private fun GymSedeDetailScreenPreview() {
    AndroidgimnasioTheme {
        GymSedeDetailScreen()
    }
}