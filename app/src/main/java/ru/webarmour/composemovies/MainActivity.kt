package ru.webarmour.composemovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.webarmour.composemovies.navigation.SetupNavHost
import ru.webarmour.composemovies.ui.theme.ComposeMoviesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMoviesTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                Scaffold {
                    Surface (
                        modifier = Modifier.padding(it)
                    ){
                        SetupNavHost(navController, viewModel = viewModel)
                    }

                }


            }
        }
    }
}
