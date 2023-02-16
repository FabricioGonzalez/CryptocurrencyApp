package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimePageEpisodeDto(
    val currentPage: String,
    val hasNextPage: Boolean,
    val results: List<AnimeEpisodeDto>
)

data class AnimeEpisodeDto(
    val id: String,
    val episodeId: String,
    val episodeNumber: Int,
    val title: String,
    val image: String,
    val url: String
)

/*
* {"id":"tomo-chan-wa-onnanoko",
* "episodeId":"tomo-chan-wa-onnanoko-episode-7",
* "episodeNumber":7,
* "title":"Tomo-chan wa Onnanoko!",
* "image":"https://gogocdn.net/cover/tomo-chan-wa-onnanoko-1672333039.png",
* "url":"https://www.gogoanime.dk/tomo-chan-wa-onnanoko-episode-7"
* */