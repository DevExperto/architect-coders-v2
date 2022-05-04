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

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            Main(
                onMovieClicked = {
                    Log.d("Movie", movies.toString())
                    navController.navigate(route = "detail/${it.id}")
                }
            )
        }
        composable(
            "detail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) {
            Detail(onBack = { navController.popBackStack() })
        }
    }
}