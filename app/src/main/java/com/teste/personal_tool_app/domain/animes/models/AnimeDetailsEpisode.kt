package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeDetailsEpisodeDto

data class AnimeDetailsEpisode(
    val id: String = "",
    val number: Int = 0,
    val url: String = ""
)

fun AnimeDetailsEpisode.toDTO(): AnimeDetailsEpisodeDto {
    return AnimeDetailsEpisodeDto(
        url = this.url,
        number = this.number,
        id = this.id
    )
}

fun AnimeDetailsEpisodeDto.toEntity(): AnimeDetailsEpisode {
    return AnimeDetailsEpisode(
        url = this.url,
        number = this.number,
        id = this.id
    )
}