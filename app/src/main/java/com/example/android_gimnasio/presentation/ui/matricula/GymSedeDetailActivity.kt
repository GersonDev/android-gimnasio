package com.example.android_gimnasio.presentation.ui.matricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.ui.matricula.components.GymSedeDetailPantalla
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class GymSedeDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.intent.extras
        val marcaDeSede = bundle?.getString("SEDE_TITULO")
        val imagenDeSede = bundle?.getInt("SEDE_IMAGEN")
        setContent {
            AndroidgimnasioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GymSedeDetailScreen(marcaDeSede!!)
                }
            }
        }
    }
}

@Composable
private fun GymSedeDetailScreen(marcaDeSede: String) {
    val navController = rememberNavController()
    GymSedeDetailPantalla(marcaDeSede = marcaDeSede)
}

@Preview(showBackground = true)
@Composable
private fun GymSedeDetailScreenPreview() {
    AndroidgimnasioTheme {
        GymSedeDetailScreen("Gym")
    }
}