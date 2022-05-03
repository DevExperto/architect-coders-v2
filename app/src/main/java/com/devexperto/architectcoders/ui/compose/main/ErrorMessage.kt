package com.devexperto.architectcoders.ui.compose.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorMessage(error: String) {
    Text(
        text = error,
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.error,
    )
}
