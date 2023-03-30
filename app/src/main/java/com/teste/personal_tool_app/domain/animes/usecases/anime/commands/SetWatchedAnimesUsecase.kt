package com.teste.personal_tool_app.domain.animes.usecases.anime.commands

import com.teste.personal_tool_app.domain.animes.repositories.AnimeDatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

data class SetWatchedAnimesUsecaseParam(
    val animeId: String,
    val episodeNumber: Int,
    val watchedTime: Long,
    val reaminingTime: Long
)

class SetWatchedAnimesUsecase @Inject constructor(
    private val animeRepository: AnimeDatabaseRepository
) {
    operator fun invoke(anime: SetWatchedAnimesUsecaseParam): Flow<Any> = flow {
        animeRepository.setLastEpisodeWatched(
            animeId = anime.animeId,
            episodeNumber = anime.episodeNumber,
            watchedDuration = anime.watchedTime,
            remainingDuration = anime.reaminingTime
        )
    }
}