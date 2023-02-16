package com.teste.personal_tool_app.presentation.animes.anime_player.viewmodels

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimePlayerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val player: Player
) : ViewModel() {

    private val videoUris = savedStateHandle.getStateFlow("videoUris", emptyList<Uri>())

    init {
        player.prepare()
    }

    fun addVideoItem() {

    }

    fun playVideo() {
        val uri =
            Uri.parse("https://wwwx12.gofcdn.com/videos/hls/WdX0hJGxxHkHVRnE46u3Lg/1676490507/184141/0789fd4f049c3ca2a49b860ea5d1f456/ep.1.1657688325.360.m3u8")

        player.setMediaItem(MediaItem.fromUri(uri))
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}