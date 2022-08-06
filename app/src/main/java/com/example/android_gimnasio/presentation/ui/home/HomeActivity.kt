package com.example.android_gimnasio.presentation.ui.home

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Brand
import com.example.android_gimnasio.presentation.routes.BottomNavItem
import com.example.android_gimnasio.presentation.ui.matricula.GymSedeDetailActivity
import com.example.android_gimnasio.presentation.ui.home.components.*
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class HomeActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidgimnasioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PrincipalScreenView(homeViewModel, {
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun PrincipalScreenView(homeViewModel: HomeViewModel, onCerrarSesion: () -> Unit) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            GymBottomNavigation(navController)
        },
        content = { innerPadding ->
            NavigationGraph(
                navController,
                homeViewModel = homeViewModel,
                innerPadding,
                onCerrarSesion = onCerrarSesion
            )
        }
    )
}

@Composable
fun GymBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Gym,
        BottomNavItem.NearMe,
        BottomNavItem.Trainer,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.trainers_primary),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoute,
                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    paddingValues: PaddingValues,
    onCerrarSesion: () -> Unit
) {
    val correo by homeViewModel.email.observeAsState("")
    val password by homeViewModel.password.observeAsState("")
    val context = LocalContext.current
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.screenRoute,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(BottomNavItem.Home.screenRoute) {
            HomePantalla()
        }
        composable(BottomNavItem.Gym.screenRoute) {
            GymBrandsPantalla(
                listOf(
                    Brand("Gold's Gym", R.drawable.brand_gold_gym),
                    Brand("SmartFit", R.drawable.brand_smart_fit),
                    Brand("Bodytech", R.drawable.brand_bodytech),
                    Brand("Megaforce", R.drawable.brand_megaforce),
                    Brand("Megatlon", R.drawable.brand_megatlon),
                    Brand("Gimnasio B2", R.drawable.b2_gimnasio),
                    Brand("Aldo's Gym", R.drawable.aldos_gym),
                    Brand("X Sport Gym", R.drawable.x_sport_gym),
                    Brand("Master Gym", R.drawable.master_gym),
                    Brand("Fitness de Impacto", R.drawable.fitness_de_impacto),
                    Brand("Sportlife Fitness Club", R.drawable.sportlife_fitness_club)
                ),
                onClickBrand = { tituloDeMarca, imagenDeMarca ->
                    homeViewModel.setTituloDeMarca(tituloDeMarca)
                    homeViewModel.setImagenDeMarca(imagenDeMarca)

                    navController.navigate(BottomNavItem.GymSedes.screenRoute)
                }
            )
        }
        composable(BottomNavItem.NearMe.screenRoute) {
            NearMePantalla(
                homeViewModel = homeViewModel,
                onBusSelected = {

                }
            )
        }
        composable(BottomNavItem.Trainer.screenRoute) {
            TrainerPantalla()
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfilePantalla(
                onClickActualizar = {
                    homeViewModel.updatePeople(context, cerrarSesion = 1)
                },
                onClickCerrarSesion = {
                    homeViewModel.cerrarsesion(context = context)
                    onCerrarSesion()
                },
                onValueChangeEmail = {
                    homeViewModel.enviarCorreo(it)
                },
                onValueChangePassword = {
                    homeViewModel.enviarPassword(it)
                },
                password = password,
                email = correo,
            )
        }
        composable(BottomNavItem.GymSedes.screenRoute) {
            GymSedesPantalla(homeViewModel.tituloDeMarca.value!!,
                homeViewModel.imagenDeMarca.value!!,
                onClickSede = {
                    val bundle = Bundle()
                    bundle.putString("SEDE_TITULO", it.titulo)
                    bundle.putInt("SEDE_IMAGEN", it.imagen)
                    val intent = Intent(context, GymSedeDetailActivity::class.java)
                    intent.putExtras(bundle)
                    context.startActivity(intent)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidgimnasioTheme {
        PrincipalScreenView(
            homeViewModel = HomeViewModel(application = Application()),
            onCerrarSesion = {}
        )
    }
}