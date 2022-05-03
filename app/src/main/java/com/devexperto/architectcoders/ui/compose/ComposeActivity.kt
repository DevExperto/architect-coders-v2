package com.devexperto.architectcoders.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.devexperto.architectcoders.domain.Movie
import com.devexperto.architectcoders.ui.compose.main.Main

@ExperimentalFoundationApi
class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main(movies)
        }
    }
}

val movies = (1..10).map {
    Movie(
        1,
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