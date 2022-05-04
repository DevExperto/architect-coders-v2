package com.devexperto.architectcoders.ui.compose.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.devexperto.architectcoders.ui.compose.Screen
import com.devexperto.architectcoders.ui.compose.main.ErrorMessage
import com.devexperto.architectcoders.ui.compose.main.errorToString
import com.devexperto.architectcoders.ui.detail.DetailViewModel

@Composable
fun Detail(viewModel: DetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Detail(state)
}

@Composable
fun Detail(state: DetailViewModel.UiState) {
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(findTitle(state)) }
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (state.movie != null) {
                    MovieDetail(state.movie)
                }
                if (state.error != null) {
                    ErrorMessage(errorToString(state.error))
                }
            }
        }
    }

}

@Composable
fun findTitle(state: DetailViewModel.UiState): String = when {
    state.movie != null -> state.movie.title
    state.error != null -> errorToString(state.error)
    else -> ""
}
