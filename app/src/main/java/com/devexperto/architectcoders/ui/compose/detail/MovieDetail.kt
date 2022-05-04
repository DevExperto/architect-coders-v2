package com.devexperto.architectcoders.ui.compose.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devexperto.architectcoders.domain.Movie

@Composable
fun MovieDetail(movie: Movie) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = movie.backdropPath,
            contentDescription = movie.title,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = movie.overview,
            modifier = Modifier.padding(16.dp)
        )
        MovieDetailInfo(movie = movie)
    }
}