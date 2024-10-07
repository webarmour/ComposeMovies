package ru.webarmour.composemovies.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.webarmour.composemovies.MainViewModel
import ru.webarmour.composemovies.data.models.MovieDto

private const val TAG = "MainScreen"
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach {
        Log.d(TAG, "MainScreen: $it ")
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(10)){
                MovieItem(item = it)
            }
        }
    }
}

@Composable
fun MovieItem(item: MovieDto){

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = item.id.toString())
        Text(text = item.name)

    }

}