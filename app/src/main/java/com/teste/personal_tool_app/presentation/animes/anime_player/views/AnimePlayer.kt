package com.teste.personal_tool_app.presentation.animes.anime_player.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.ui.PlayerView
import com.teste.personal_tool_app.presentation.animes.anime_player.viewmodels.AnimePlayerViewModel

@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun AnimePlayer() {

    val viewModel = hiltViewModel<AnimePlayerViewModel>()

    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)

    }
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner) {
        val observer =
            LifecycleEventObserver { _, event -> lifecycle = event }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    AndroidView(
        factory = { context ->
            PlayerView(context).also {
                it.player = viewModel.player
                viewModel.playVideo()
            }
        },
        update = {
            when (lifecycle) {
                Lifecycle.Event.ON_PAUSE -> {
                    it.onPause()
                    it.player?.pause()
                }
                Lifecycle.Event.ON_RESUME -> {
                    it.onResume()
                }
                else -> Unit
            }
        },
        modifier = Modifier
            .fillMaxSize()
    )

}
