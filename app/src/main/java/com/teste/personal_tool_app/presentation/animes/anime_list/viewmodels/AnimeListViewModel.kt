package com.teste.personal_tool_app.presentation.animes.anime_list.viewmodels

import androidx.lifecycle.ViewModel
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeDto
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeEpisodeDto
import com.teste.personal_tool_app.data.remote.animes.dto.TopAiringAnimeDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
@HiltViewModel
class AnimeListViewModel @Inject constructor() : ViewModel() {
    private val _animeList: MutableStateFlow<List<AnimeDto>> = MutableStateFlow(
        listOf(
            AnimeDto(
                id = "kishin-douji-zenki",
                image = "https://gogocdn.net/cover/kishin-douji-zenki.png",
                releaseDate = "Released: 1995",
                subOrDub = "1995",
                url = "https://www.gogoanime.dk//category/kishin-douji-zenki",
                title = "Kishin Douji Zenki"
            ),
            AnimeDto(
                id = "kishin-douji-zenki",
                image = "https://gogocdn.net/cover/kishin-douji-zenki.png",
                releaseDate = "Released: 1995",
                subOrDub = "1995",
                url = "https://www.gogoanime.dk//category/kishin-douji-zenki",
                title = "Kishin Douji Zenki"
            ),
            AnimeDto(
                id = "kishin-douji-zenki",
                image = "https://gogocdn.net/cover/kishin-douji-zenki.png",
                releaseDate = "Released: 1995",
                subOrDub = "1995",
                url = "https://www.gogoanime.dk//category/kishin-douji-zenki",
                title = "Kishin Douji Zenki"
            ),
            AnimeDto(
                id = "kishin-douji-zenki",
                image = "https://gogocdn.net/cover/kishin-douji-zenki.png",
                releaseDate = "Released: 1995",
                subOrDub = "1995",
                url = "https://www.gogoanime.dk//category/kishin-douji-zenki",
                title = "Kishin Douji Zenki"
            )
        )
    )

    val animeList = _animeList.asStateFlow()

    private val _keepWatchingList: MutableStateFlow<List<AnimeEpisodeDto>> = MutableStateFlow(
        listOf(
            AnimeEpisodeDto(
                id = "tomo-chan-wa-onnanoko",
                image = "https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
                episodeNumber = 7,
                episodeId = "tomo-chan-wa-onnanoko-episode-7",
                url = "https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7",
                title = "Tomo-chan wa Onnanoko!"
            ),
            AnimeEpisodeDto(
                id = "tomo-chan-wa-onnanoko",
                image = "https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
                episodeNumber = 7,
                episodeId = "tomo-chan-wa-onnanoko-episode-7",
                url = "https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7",
                title = "Tomo-chan wa Onnanoko!"
            ),
            AnimeEpisodeDto(
                id = "tomo-chan-wa-onnanoko",
                image = "https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
                episodeNumber = 7,
                episodeId = "tomo-chan-wa-onnanoko-episode-7",
                url = "https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7",
                title = "Tomo-chan wa Onnanoko!"
            ),
            AnimeEpisodeDto(
                id = "tomo-chan-wa-onnanoko",
                image = "https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
                episodeNumber = 7,
                episodeId = "tomo-chan-wa-onnanoko-episode-7",
                url = "https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7",
                title = "Tomo-chan wa Onnanoko!"
            )
        )
    )

    val keepWatchingList = _keepWatchingList.asStateFlow()
    private val _topAiringList: MutableStateFlow<List<TopAiringAnimeDto>> = MutableStateFlow(
        listOf(
            TopAiringAnimeDto(
                id = "vinland-saga-season-2",
                image = "https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
                genres = listOf("Action", "Adventure", "Drama", "Gore", "Seinen"),
                url = "https://www.gogoanime.dk/category/vinland-saga-season-2",
                title = "Vinland Saga Season 2"
            ),
            TopAiringAnimeDto(
                id = "vinland-saga-season-2",
                image = "https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
                genres = listOf("Action", "Adventure", "Drama", "Gore", "Seinen"),
                url = "https://www.gogoanime.dk/category/vinland-saga-season-2",
                title = "Vinland Saga Season 2"
            ),
            TopAiringAnimeDto(
                id = "vinland-saga-season-2",
                image = "https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
                genres = listOf("Action", "Adventure", "Drama", "Gore", "Seinen"),
                url = "https://www.gogoanime.dk/category/vinland-saga-season-2",
                title = "Vinland Saga Season 2"
            ),
            TopAiringAnimeDto(
                id = "vinland-saga-season-2",
                image = "https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
                genres = listOf("Action", "Adventure", "Drama", "Gore", "Seinen"),
                url = "https://www.gogoanime.dk/category/vinland-saga-season-2",
                title = "Vinland Saga Season 2"
            ),
        )
    )

    val topAiringList = _topAiringList.asStateFlow()


}