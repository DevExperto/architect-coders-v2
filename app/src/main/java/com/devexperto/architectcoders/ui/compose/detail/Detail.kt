package com.devexperto.architectcoders.ui.compose.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.devexperto.architectcoders.R
import com.devexperto.architectcoders.ui.compose.Screen
import com.devexperto.architectcoders.ui.compose.main.ErrorMessage
import com.devexperto.architectcoders.ui.compose.main.errorToString
import com.devexperto.architectcoders.ui.detail.DetailViewModel

@Composable
fun Detail(viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit) {
    val state by viewModel.state.collectAsState()
    Detail(
        state = state,
        onBack = onBack,
        onFavoriteClick = { viewModel.onFavoriteClicked() }
    )
}

@Composable
fun Detail(state: DetailViewModel.UiState, onBack: () -> Unit, onFavoriteClick: () -> Unit) {
    val (movie, error) = state

    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(findTitle(state)) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(R.string.navigate_back)
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                if (movie != null) {
                    FloatingActionButton(onClick = onFavoriteClick) {
                        Icon(
                            imageVector = if (movie.favorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(id = R.string.switch_favorite)
                        )
                    }
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (movie != null) {
                    MovieDetail(movie)
                }
                if (error != null) {
                    ErrorMessage(errorToString(error))
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
