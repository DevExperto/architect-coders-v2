package com.devexperto.architectcoders.ui.compose.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.devexperto.architectcoders.R
import com.devexperto.architectcoders.domain.Error
import com.devexperto.architectcoders.ui.compose.Screen
import com.devexperto.architectcoders.ui.main.MainViewModel

@ExperimentalFoundationApi
@Composable
fun Main(state: MainViewModel.UiState) {
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(id = R.string.app_name)) }
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (state.movies != null) {
                    MoviesGrid(state.movies)
                }
                if (state.loading) {
                    CircularProgressIndicator()
                }
                if (state.error != null) {
                    ErrorMessage(errorToString(state.error))
                }
            }
        }
    }
}

@Composable
fun errorToString(error: Error): String {
    val context = LocalContext.current
    return when (error) {
        Error.Connectivity -> context.getString(R.string.connectivity_error)
        is Error.Server -> context.getString(R.string.server_error) + error.code
        is Error.Unknown -> context.getString(R.string.unknown_error) + error.message
    }
}