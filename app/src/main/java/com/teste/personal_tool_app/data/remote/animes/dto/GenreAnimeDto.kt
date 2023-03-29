package com.teste.personal_tool_app.data.remote.animes.dto

data class GenreAnimePageDto(
    val currentPage: String,
    val hasNextPage: Boolean,
    val results: List<GenreAnimeDto>
)

data class GenreAnimeDto(
    val id: String,
    val title: String,
    val url: String,
    val image: String,
    val releaseDate: String
)

