package ru.webarmour.composemovies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import ru.webarmour.composemovies.MainViewModel
import ru.webarmour.composemovies.data.models.MovieDto
import ru.webarmour.composemovies.navigation.Screens
import ru.webarmour.composemovies.utils.Constants

private const val TAG = "MainScreen"

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value



    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(allMovies.take(10)) {
                MovieItem(item = it, navController = navController)
            }
        }
    }
}

@Composable
fun MovieItem(item: MovieDto, navController: NavHostController) {

    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.DetailScreenRoute.route + "/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium), contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row (modifier = Modifier.padding(top = 6.dp)) {
                    Text(
                        text = "Rating: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.rating.average.toString())
                }
                Row(modifier = Modifier.padding(top = 6.dp)) {
                    Text(
                        text = "Genre:",
                        fontWeight = FontWeight.Bold
                    )
                    item.genres.take(2).forEach {
                        Text(text =" $it")
                    }
                }
                Row (modifier = Modifier.padding(top = 6.dp)){
                    Text(
                        text = "Premiered: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.premiered)
                }
            }

        }

    }

}