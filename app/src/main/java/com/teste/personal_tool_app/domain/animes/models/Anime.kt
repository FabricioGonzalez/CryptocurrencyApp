package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeDto

data class Anime(
    val id: String,
    val title: String,
    val url: String,
    val image: String,
    val releaseDate: String,
    val subOrDub: String
)

fun Anime.toDTO(): AnimeDto {
    return AnimeDto(
        title = this.title,
        url = this.url,
        subOrDub = this.subOrDub,
        image = this.image,
        releaseDate = this.releaseDate,
        id = this.id
    )
}

fun AnimeDto.toEntity(): Anime {
    return Anime(
        title = this.title,
        url = this.url,
        subOrDub = this.subOrDub,
        image = this.image,
        releaseDate = this.releaseDate,
        id = this.id
    )
}