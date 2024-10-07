package ru.webarmour.composemovies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.webarmour.composemovies.screens.MainScreen
import ru.webarmour.composemovies.screens.SplashScreen
import ru.webarmour.composemovies.utils.Constants

sealed class Screens(val route: String) {
    object SplashScreenRoute : Screens(Constants.Screens.SPLASH_SCREEN)
    object MainScreenRoute : Screens(Constants.Screens.MAIN_SCREEN)
    object DetailScreenRoute : Screens(Constants.Screens.DETAIL_SCREEN)
}


@Composable
fun SetupNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreenRoute.route
    ) {
        composable(route = Screens.SplashScreenRoute.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.MainScreenRoute.route) {
            MainScreen()
        }
        composable(route = Screens.DetailScreenRoute.route) {

        }
    }
}