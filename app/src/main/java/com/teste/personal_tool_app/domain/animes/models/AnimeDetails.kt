package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeDetailsDto

data class AnimeDetails(
    val id: String,
    val title: String,
    val url: String,
    val image: String,
    val releaseDate: String? = "",
    val description: String? = "",
    val subOrDub: String,
    val type: String? = "",
    val status: String,
    val otherName: String? = "",
    val genres: List<String>,
    val totalEpisodes: Int,
    val episodes: List<AnimeDetailsEpisode>
)

fun AnimeDetails.toDTO(): AnimeDetailsDto {
    return AnimeDetailsDto(
        id = id,
        title = title,
        url = url,
        image = image,
        releaseDate = releaseDate,
        description = description,
        subOrDub = subOrDub,
        type = type,
        status = status,
        otherName = otherName,
        genres = genres,
        totalEpisodes = totalEpisodes,
        episodes = episodes.map { it.toDTO() }
    )
}

fun AnimeDetailsDto.toEntity(): AnimeDetails {
    return AnimeDetails(
        id = id,
        title = title,
        url = url,
        image = image,
        releaseDate = releaseDate,
        description = description,
        subOrDub = subOrDub,
        type = type,
        status = status,
        otherName = otherName,
        genres = genres,
        totalEpisodes = totalEpisodes,
        episodes = episodes.map { it.toEntity() }
    )
}