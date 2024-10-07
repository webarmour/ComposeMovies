package ru.webarmour.composemovies.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.webarmour.composemovies.MainViewModel

@Composable
fun DetailScreen(navController: NavController, viewModel: MainViewModel, itemId:String){
        Text(text = "Details screen: item id: $itemId")
}