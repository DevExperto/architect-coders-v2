package com.devexperto.architectcoders.ui.compose.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devexperto.architectcoders.domain.Movie

@Composable
fun MovieItem(movie: Movie, modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Column {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1f / 1.5f)
            )
            val bgColor = MaterialTheme.colors.primaryVariant
            Text(
                text = movie.title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(bgColor)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .wrapContentHeight(),
                color = contentColorFor(backgroundColor = bgColor),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (movie.favorite) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            )
        }
    }
}