package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.TopAiringAnimeDto

data class TopAiringAnime(
    val id: String,
    val title: String,
    val image: String,
    val url: String,
    val genres: List<String>
)

fun TopAiringAnime.toDTO(): TopAiringAnimeDto {
    return TopAiringAnimeDto(
        title = this.title,
        url = this.url,
        genres = this.genres,
        image = this.image,
        id = this.id
    )
}

fun TopAiringAnimeDto.toEntity(): TopAiringAnime {
    return TopAiringAnime(
        title = this.title,
        url = this.url,
        genres = this.genres,
        image = this.image,
        id = this.id
    )
}