package com.teste.personal_tool_app.data.repositories.animes

import com.teste.personal_tool_app.data.room_database.DatabaseSpecs
import com.teste.personal_tool_app.data.room_database.entities.WatchedEpisodesDBEntity
import com.teste.personal_tool_app.data.room_database.entities.toEntity
import com.teste.personal_tool_app.domain.animes.models.AnimeGenre
import com.teste.personal_tool_app.domain.animes.repositories.AnimeDatabaseRepository
import javax.inject.Inject

class AnimeRoomRepositoryImpl @Inject constructor(
    private val database: DatabaseSpecs
) : AnimeDatabaseRepository {
    override suspend fun setLastEpisodeWatched(
        animeId: String,
        episodeNumber: Int,
        watchedDuration: Long,
        remainingDuration: Long
    ) {
        database
            .episodesDAO()
            .addLastWatchedEpisode(
                WatchedEpisodesDBEntity(
                    animeId = animeId,
                    episodeNumber = episodeNumber,
                    watchedTime = watchedDuration,
                    remainingTime = remainingDuration
                )
            )
    }

    override suspend fun getAllPreferredGenres(): List<AnimeGenre> {
        return database
            .genreDAO()
            .getAllGenres()
            .map { it.toEntity() }
    }

    override suspend fun getAllGenres(): List<AnimeGenre> {
        return database
            .genreDAO()
            .getAllGenres()
            .map { it.toEntity() }
    }

}