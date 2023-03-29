package com.teste.personal_tool_app.presentation.animes.anime_list.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teste.personal_tool_app.common.onError
import com.teste.personal_tool_app.common.onLoading
import com.teste.personal_tool_app.common.onSucess
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeEpisodeDto
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeSearchingDto
import com.teste.personal_tool_app.data.remote.animes.dto.TopAiringAnimeDto
import com.teste.personal_tool_app.domain.animes.enums.AnimeGenres
import com.teste.personal_tool_app.domain.animes.models.toDTO
import com.teste.personal_tool_app.domain.animes.usecases.get_animes.GetAnimesUsecase
import com.teste.personal_tool_app.domain.animes.usecases.get_animes_by_genre.GetAnimesByGenreUsecase
import com.teste.personal_tool_app.domain.animes.usecases.get_searching_animes.GetSearchingAnimesUsecase
import com.teste.personal_tool_app.domain.animes.usecases.get_top_airing_animes.GetTopAiringAnimesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* {"id":"tomo-chan-wa-onnanoko",
* "episodeId":"tomo-chan-wa-onnanoko-episode-7",
* "episodeNumber":7,
* "title":"Tomo-chan wa Onnanoko!",
* "image":"https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
* "url":"https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7"
* */

/* "id":"vinland-saga-season-2",
* "title":"Vinland Saga Season 2",
* "image":"https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
* "url":"https://www.gogoanime.dk/category/vinland-saga-season-2",
* "genres":["Action","Adventure","Drama","Gore","Seinen"]}
* */
@OptIn(FlowPreview::class)
@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val getAnimesUsecase: GetAnimesUsecase,
    private val getTopAiringAnimesUsecase: GetTopAiringAnimesUsecase,
    private val getSearchingAnimesUsecase: GetSearchingAnimesUsecase,
    private val getAnimesByGenreUsecase: GetAnimesByGenreUsecase
) : ViewModel() {
    private val _animeList: MutableStateFlow<List<AnimeEpisodeDto>> = MutableStateFlow(
        emptyList()
    )
    val animeList = _animeList.asStateFlow()

    private val _keepWatchingList: MutableStateFlow<List<AnimeEpisodeDto>> = MutableStateFlow(
        emptyList()
    )
    val keepWatchingList = _keepWatchingList.asStateFlow()

    private val _topAiringList: MutableStateFlow<List<TopAiringAnimeDto>> = MutableStateFlow(
        emptyList()
    )
    val topAiringList = _topAiringList.asStateFlow()

    private val _searchText: MutableStateFlow<String> = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _seachingList: MutableStateFlow<List<AnimeSearchingDto>> = MutableStateFlow(
        emptyList()
    )
    val seachingList = _seachingList.asStateFlow()

    init {
        loadAnimes()
        loadTopAiringAnimes()
        viewModelScope.launch {

            searchText.debounce(1000L).collect { searchValue ->
                if (searchValue.isNotBlank()) {
                    _isSearching.tryEmit(true)

                    getSearchingAnimesUsecase(searchValue).collect { animes ->
                        animes.onSucess {
                            _seachingList.tryEmit(animes.data?.map {
                                it.toDTO()
                            } ?: emptyList())
                        }
                        animes.onError {

                        }
                        animes.onLoading {

                        }
                    }
                } else {
                    _isSearching.tryEmit(false)
                }
            }
        }
    }

    fun searchAnimes(searchValue: String) {
        _searchText.tryEmit(searchValue)
    }

    private fun loadAnimes() {
        viewModelScope.launch {
            getAnimesUsecase().collect { animes ->
                animes.onSucess {
                    _animeList.tryEmit(animes.data?.map {
                        it.toDTO()
                    } ?: emptyList())
                }
                animes.onError {

                }
                animes.onLoading {

                }
            }

        }
    }

    private fun loadKeepWatchingAnime() {
    }

    private fun loadAnimesByMostWatchedGenres() {
        getAnimesByGenreUsecase(AnimeGenres.Ecchi)
    }

    private fun loadTopAiringAnimes() {
        viewModelScope.launch {
            getTopAiringAnimesUsecase().collect { animes ->
                animes.onSucess {
                    _topAiringList.tryEmit(animes.data?.map {
                        it.toDTO()
                    } ?: emptyList())
                }
                animes.onError {
                }
                animes.onLoading {
                }
            }
        }
    }
}