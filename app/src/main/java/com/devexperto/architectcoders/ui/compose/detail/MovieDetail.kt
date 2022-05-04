package com.devexperto.architectcoders.ui.compose.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.devexperto.architectcoders.domain.Movie

@Composable
fun MovieDetail(movie: Movie) {
    Text(text = movie.title)
}