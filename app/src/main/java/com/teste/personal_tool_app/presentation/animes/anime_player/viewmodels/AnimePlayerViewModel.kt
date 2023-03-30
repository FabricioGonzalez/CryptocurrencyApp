package com.teste.personal_tool_app.presentation.animes.anime_player.viewmodels

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import com.teste.personal_tool_app.common.Constants
import com.teste.personal_tool_app.common.onError
import com.teste.personal_tool_app.common.onLoading
import com.teste.personal_tool_app.common.onSucess
import com.teste.personal_tool_app.domain.animes.usecases.anime.queries.GetStreamingEpisodeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@UnstableApi
@HiltViewModel
class AnimePlayerViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getStreamingEpisodeUsecase: GetStreamingEpisodeUsecase,
    val player: Player
) : ViewModel() {

    private val videoUris = savedStateHandle.getStateFlow("videoUris", emptyList<Uri>())
    private val videoUri = savedStateHandle.getStateFlow("videoUri", Uri.EMPTY)


    init {
        savedStateHandle.get<String>(Constants.PARAM_ANIME_EPISODE_ID)?.let { episodeId ->
            getUrlToPlay(episodeId)
        }
        player.prepare()
    }

    private fun getUrlToPlay(episodeId: String) {
        viewModelScope.launch {
            getStreamingEpisodeUsecase(episodeId).collect { result ->
                result.onSucess {
                    savedStateHandle["videoUri"] = Uri.parse(it.data?.sources?.first()?.url)
                }

                result.onError { }

                result.onLoading { }
            }

        }
    }

    fun playVideo() {
        viewModelScope.launch {
            videoUri.collect {
                if (it != Uri.EMPTY) {
                    val mediaItem: MediaItem = MediaItem.Builder()
                        .setUri(it)
                        .setMimeType(MimeTypes.APPLICATION_M3U8)
                        .build()

                    player.setMediaItem(mediaItem)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        player.release()
    }
}