package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimeSearchingPageDto(
    val currentPage: Int = 0,
    val hasNextPage: Boolean = true,
    val results: List<AnimeSearchingDto> = emptyList()
)

data class AnimeSearchingDto(
    val id: String,
    val title: String,
    val image: String,
    val releaseDate: String,
    val subOrDub: String
)