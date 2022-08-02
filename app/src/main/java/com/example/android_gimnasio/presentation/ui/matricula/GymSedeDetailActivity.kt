package com.example.android_gimnasio.presentation.ui.matricula

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.presentation.routes.MatricularseScreen
import com.example.android_gimnasio.presentation.ui.home.components.ModalDeMatricula
import com.example.android_gimnasio.presentation.ui.matricula.components.GymSedeDetailPantalla
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class GymSedeDetailActivity : ComponentActivity() {

    private val gymSedesDetailViewModel by viewModels<GymSedesDetailViewModel>()
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
                    GymSedeDetailScreen(gymSedesDetailViewModel)
                }
            }
        }
    }
}

@Composable
private fun GymSedeDetailScreen(gymSedesDetailViewModel: GymSedesDetailViewModel) {
    val matriculaExitoso by gymSedesDetailViewModel.matriculaexitosa.observeAsState()
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController, startDestination = MatricularseScreen.GymSedeDetail.route) {
        composable(MatricularseScreen.GymSedeDetail.route) {
            GymSedeDetailPantalla(
                marcaDeSede = "",
                onClickMatricularse = {
                    gymSedesDetailViewModel.startLogin(context)
                },
            )
            when (matriculaExitoso) {
                null -> {

                }
                true -> {
                    navController.navigate(MatricularseScreen.GymSedeDetail.route)
                }
                false -> {
                    ModalDeMatricula {
                        gymSedesDetailViewModel.ocultarModal()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GymSedeDetailScreenPreview() {
    AndroidgimnasioTheme {
        GymSedeDetailScreen(gymSedesDetailViewModel = GymSedesDetailViewModel())
    }
}