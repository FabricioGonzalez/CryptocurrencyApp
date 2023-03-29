package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeEpisodeDto

data class AnimeEpisode(
    val id: String,
    val episodeId: String,
    val episodeNumber: Int,
    val title: String,
    val image: String,
    val url: String
)

fun AnimeEpisode.toDTO(): AnimeEpisodeDto {
    return AnimeEpisodeDto(
        title = this.title,
        url = this.url,
        episodeId = this.episodeId,
        episodeNumber = this.episodeNumber,
        image = this.image,
        id = this.id
    )
}

fun AnimeEpisodeDto.toEntity(): AnimeEpisode {
    return AnimeEpisode(
        title = this.title,
        url = this.url,
        episodeId = this.episodeId,
        episodeNumber = this.episodeNumber,
        image = this.image,
        id = this.id
    )
}