package ru.webarmour.composemovies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.HtmlText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import ru.webarmour.composemovies.MainViewModel
import ru.webarmour.composemovies.utils.HtmlText

@Composable
fun DetailScreen(viewModel: MainViewModel, itemId:String){

        val currentItem = viewModel.allMovies.observeAsState(listOf()).value
                .firstOrNull{it.id == itemId.toInt()}

        Surface(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 24.dp, horizontal = 8.dp)
        ) {
              LazyColumn {
                      item {   Column(
                              horizontalAlignment = Alignment.CenterHorizontally
                      ) {
                              Image(
                                      painter = rememberImagePainter(currentItem?.image?.original),
                                      contentDescription = "",
                                      modifier = Modifier.size(450.dp)
                              )
                              Text(text = currentItem?.name ?: "",
                                      fontWeight = FontWeight.Bold,
                                      fontSize = 32.sp,
                                      modifier = Modifier.padding(top = 16.dp)
                              )
                              Text(text = currentItem?.rating?.average.toString() ?: "",
                                      fontSize = 20.sp,
                                      modifier = Modifier.padding(top = 6.dp)
                              )
                              Text(text = currentItem?.genres
                                      ?.take(2)
                                      .toString()
                                      .replace("[", "")
                                      .replace("]", ""),
                                      fontSize = 20.sp,
                                      modifier = Modifier.padding(top = 6.dp)
                              )
                              HtmlText(html = currentItem?.summary ?: "",
                                      modifier = Modifier.padding(top = 6.dp),
                                      fontSize = 500.sp
                              )
                      } }
              }

        }


}