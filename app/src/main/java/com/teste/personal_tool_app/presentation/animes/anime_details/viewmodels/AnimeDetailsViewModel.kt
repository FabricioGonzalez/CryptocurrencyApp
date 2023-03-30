package com.teste.personal_tool_app.presentation.animes.anime_details.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teste.personal_tool_app.common.Constants
import com.teste.personal_tool_app.common.onError
import com.teste.personal_tool_app.common.onLoading
import com.teste.personal_tool_app.common.onSucess
import com.teste.personal_tool_app.domain.animes.models.AnimeDetails
import com.teste.personal_tool_app.domain.animes.usecases.anime.queries.GetAnimeDetailsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getAnimeDetailsUsecase: GetAnimeDetailsUsecase
) : ViewModel() {

    private val _anime: MutableStateFlow<AnimeDetails?> = MutableStateFlow(null)
    val anime: StateFlow<AnimeDetails?> = _anime.asStateFlow()

    init {
        savedStateHandle.get<String>(Constants.PARAM_ANIME_ID)?.let { animeId ->
            getAnimeDetails(animeId)
        }
    }

    private fun getAnimeDetails(animeId: String) {
        viewModelScope.launch {
            getAnimeDetailsUsecase(animeId = animeId).collect { animeReturn ->
                animeReturn.onSucess {
                    _anime.tryEmit(it.data)
                }
                animeReturn.onError {

                }
                animeReturn.onLoading {

                }

            }
        }
    }
}