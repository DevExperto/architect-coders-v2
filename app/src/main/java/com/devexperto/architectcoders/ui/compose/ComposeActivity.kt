package com.devexperto.architectcoders.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.devexperto.architectcoders.domain.Movie
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

val movies = (1..10).map {
    Movie(
        it,
        "Title $it",
        "",
        "",
        "https://loremflickr.com/200/400/cover?lock=$it",
        "",
        "EN",
        "Title $it",
        5.1,
        2.2,
        it % 3 == 0
    )
}