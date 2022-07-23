package com.example.android_gimnasio.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.android_gimnasio.presentation.ui.gym_sedes.GymSedesActivity
import com.example.android_gimnasio.presentation.ui.home.components.*
import com.example.android_gimnasio.ui.theme.AndroidgimnasioTheme

class PrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidgimnasioTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    PrincipalScreenView()
                }
            }
        }
    }
}

@Composable
fun PrincipalScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        }
    ) {
        NavigationGraph(navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Gym,
        BottomNavItem.Baile,
        BottomNavItem.Trainer,
        BottomNavItem.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.plomo),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
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
fun NavigationGraph(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomePantalla()
        }
        composable(BottomNavItem.Gym.screenRoute) {
            GymPantalla(
                listOf(
                    Brand("Gold's Gym", R.drawable.brand_gold_gym),
                    Brand("SmartFit", R.drawable.brand_smart_fit),
                    Brand("Bodytech", R.drawable.brand_bodytech),
                    Brand("Megaforce", R.drawable.brand_megaforce),
                    Brand("Megatlon", R.drawable.brand_megatlon),
                    Brand("Gimnasio B2", R.drawable.brand_megaforce),
                    Brand("Aldo's Gym", R.drawable.brand_smart_fit),
                    Brand("X Sport Gym", R.drawable.brand_megatlon),
                    Brand("Master Gym", R.drawable.brand_bodytech),
                    Brand("Fitness de Impacto", R.drawable.brand_gold_gym),
                    Brand("Sportlife Fitness Club", R.drawable.brand_smart_fit)
                ),
                onClickBrand = {
                    context.startActivity(Intent(context, GymSedesActivity::class.java))
                }
            )
        }
        composable(BottomNavItem.Baile.screenRoute) {
            BailePantalla()
        }
        composable(BottomNavItem.Trainer.screenRoute) {
            TrainerPantalla()
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfilePantalla()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidgimnasioTheme {
        PrincipalScreenView()
    }
}