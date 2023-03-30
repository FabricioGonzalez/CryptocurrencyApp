package com.teste.personal_tool_app.domain.animes.repositories

import com.teste.personal_tool_app.domain.animes.models.AnimeGenre

interface AnimeDatabaseRepository {
    suspend fun setLastEpisodeWatched(
        animeId: String,
        episodeNumber: Int,
        watchedDuration: Long,
        remainingDuration: Long
    )

    suspend fun getAllPreferredGenres(): List<AnimeGenre>

    suspend fun getAllGenres(): List<AnimeGenre>
}