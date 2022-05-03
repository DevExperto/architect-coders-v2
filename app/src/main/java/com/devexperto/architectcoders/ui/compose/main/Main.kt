package com.devexperto.architectcoders.ui.compose.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devexperto.architectcoders.R
import com.devexperto.architectcoders.domain.Movie
import com.devexperto.architectcoders.ui.compose.Screen

@ExperimentalFoundationApi
@Composable
fun Main(movies: List<Movie>) {
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(id = R.string.app_name)) }
                )
            }
        ) { padding ->
            LazyVerticalGrid(
                cells = GridCells.Adaptive(120.dp),
                modifier = Modifier.padding(padding),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(movies) { MovieItem(it) }
            }
        }
    }
}