package ru.webarmour.composemovies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.webarmour.composemovies.MainViewModel
import ru.webarmour.composemovies.screens.MainScreen
import ru.webarmour.composemovies.screens.SplashScreen
import ru.webarmour.composemovies.utils.Constants

sealed class Screens(val route: String) {
    object SplashScreenRoute : Screens(Constants.Screens.SPLASH_SCREEN)
    object MainScreenRoute : Screens(Constants.Screens.MAIN_SCREEN)
    object DetailScreenRoute : Screens(Constants.Screens.DETAIL_SCREEN)
}


@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreenRoute.route
    ) {
        composable(route = Screens.SplashScreenRoute.route) {
            SplashScreen(navController = navController, viewModel)
        }
        composable(route = Screens.MainScreenRoute.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.DetailScreenRoute.route) {

        }
    }
}