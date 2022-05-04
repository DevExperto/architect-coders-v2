package com.devexperto.architectcoders.ui.compose

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devexperto.architectcoders.ui.compose.detail.Detail
import com.devexperto.architectcoders.ui.compose.main.Main
import com.devexperto.architectcoders.ui.detail.DetailViewModel
import com.devexperto.architectcoders.ui.main.MainViewModel

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            Main(
                MainViewModel.UiState(movies = movies),
                onMovieClicked = {
                    Log.d("Movie", movies.toString())
                    navController.navigate(route = "detail/${it.id}")
                }
            )
        }
        composable(
            "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            Detail(DetailViewModel.UiState(movie = movies.find { it.id == movieId }))
        }
    }
}