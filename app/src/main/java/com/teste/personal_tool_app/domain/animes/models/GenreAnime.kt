package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.GenreAnimeDto

data class GenreAnime(
    val id: String,
    val title: String,
    val url: String,
    val image: String,
    val releaseDate: String
)

fun GenreAnime.toDTO(): GenreAnimeDto {
    return GenreAnimeDto(
        title = this.title,
        url = this.url,
        image = this.image,
        releaseDate = this.releaseDate,
        id = this.id
    )
}

fun GenreAnimeDto.toEntity(): GenreAnime {
    return GenreAnime(
        title = this.title,
        url = this.url,
        image = this.image,
        releaseDate = this.releaseDate,
        id = this.id
    )
}