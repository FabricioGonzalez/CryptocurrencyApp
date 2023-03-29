package com.teste.personal_tool_app.domain.animes.usecases.get_keep_watching_animes

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeEpisode
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetKeepWatchingAnimesUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(): Flow<List<Resource<AnimeEpisode>>> = flow {

    }
}