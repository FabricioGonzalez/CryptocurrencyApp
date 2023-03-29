package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeSearchingDto

data class AnimeSearching(
    val id: String,
    val title: String,
    val image: String,
    val releaseDate: String,
    val subOrDub: String
)

fun AnimeSearching.toDTO(): AnimeSearchingDto {
    return AnimeSearchingDto(
        id = id,
        title = title,
        image = image,
        releaseDate = releaseDate,
        subOrDub = subOrDub,
    )
}

fun AnimeSearchingDto.toEntity(): AnimeSearching {
    return AnimeSearching(
        id = id,
        title = title,
        image = image,
        releaseDate = releaseDate,
        subOrDub = subOrDub,
    )
}