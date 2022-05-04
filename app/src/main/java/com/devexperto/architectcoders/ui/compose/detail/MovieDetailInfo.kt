package com.devexperto.architectcoders.ui.compose.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devexperto.architectcoders.domain.Movie

@Composable
fun MovieDetailInfo(movie: Movie) {
    Text(
        text = buildInfoString(movie),
        modifier = Modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .fillMaxWidth()
    )
}

private fun buildInfoString(movie: Movie) =
    buildAnnotatedString {
        appendInfoLine("Original language: ", movie.originalLanguage)
        appendInfoLine("Original title: ", movie.originalTitle)
        appendInfoLine("Release date: ", movie.releaseDate)
        appendInfoLine("Popularity: ", movie.popularity.toString())
        appendInfoLine("Vote average: ", movie.voteAverage.toString(), 0)
    }

private fun AnnotatedString.Builder.appendInfoLine(
    label: String,
    value: String,
    lineBreaks: Int = 2
) {
    append(
        AnnotatedString(
            text = label,
            spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
        )
    )
    append(value)
    repeat(lineBreaks) { append("\r\n") }
}