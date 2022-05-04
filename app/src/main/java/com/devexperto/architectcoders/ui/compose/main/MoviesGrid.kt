package com.devexperto.architectcoders.ui.compose.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devexperto.architectcoders.domain.Movie

@ExperimentalFoundationApi
@Composable
fun MoviesGrid(movies: List<Movie>, onMovieClicked: (Movie) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(movies) { movie ->
            MovieItem(
                movie = movie,
                modifier = Modifier.clickable {
                    onMovieClicked(movie)
                }
            )
        }
    }
}