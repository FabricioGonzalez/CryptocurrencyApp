package com.teste.personal_tool_app.domain.animes.models

import com.teste.personal_tool_app.data.remote.animes.dto.AnimeStreamingDto
import com.teste.personal_tool_app.data.remote.animes.dto.HeadersDto
import com.teste.personal_tool_app.data.remote.animes.dto.SourcesDto

data class AnimeEpisodeStreaming(
    val headers: Headers,
    val sources: List<Sources>,
    val download: String
)

fun AnimeEpisodeStreaming.toDto(): AnimeStreamingDto {
    return AnimeStreamingDto(
        headers = headers.toDto(),
        sources = sources.map { it.toDto() },
        download = download,
    )
}

fun AnimeStreamingDto.toEntity(): AnimeEpisodeStreaming {
    return AnimeEpisodeStreaming(
        headers = headers.toEntity(),
        sources = sources.map { it.toEntity() },
        download = download
    )
}


data class Headers(
    val Referer: String,
    val watchsb: String? = "", // or null, since only provided with server being equal to "streamsb".
    val userAgent: String? = "" // or null
)

fun Headers.toDto(): HeadersDto {
    return HeadersDto(
        Referer = Referer,
        watchsb = watchsb,
        userAgent = userAgent,
    )
}

fun HeadersDto.toEntity(): Headers {
    return Headers(
        Referer = Referer,
        watchsb = watchsb,
        userAgent = userAgent
    )
}

data class Sources(
    val url: String,
    val isM3U8: Boolean,
    val quality: String
)

fun Sources.toDto(): SourcesDto {
    return SourcesDto(
        url = url,
        isM3U8 = isM3U8,
        quality = quality
    )
}

fun SourcesDto.toEntity(): Sources {
    return Sources(
        url = url,
        isM3U8 = isM3U8,
        quality = quality
    )
}

