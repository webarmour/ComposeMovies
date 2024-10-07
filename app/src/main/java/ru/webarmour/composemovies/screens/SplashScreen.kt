package ru.webarmour.composemovies.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.asFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.webarmour.composemovies.MainViewModel
import ru.webarmour.composemovies.navigation.Screens
import ru.webarmour.composemovies.ui.theme.ComposeMoviesTheme


@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModel) {

    var startAnimate by remember {
        mutableStateOf(false)
    }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(durationMillis = 3000), label = ""

    ).asFloatState()

    LaunchedEffect(key1 = true) {
        startAnimate = true
        viewModel.getAllMovies()
        delay(4000)
        navController.navigate(Screens.MainScreenRoute.route)

    }

    Splash(alpha = alphaAnimation.value)
}

@Composable()
fun Splash(alpha: Float) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = MaterialTheme.colors.primaryVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShplas() {
    ComposeMoviesTheme {
        Splash(1f)
    }

}