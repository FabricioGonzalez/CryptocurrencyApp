package com.teste.personal_tool_app.domain.animes.usecases.anime.queries

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeEpisodeStreaming
import com.teste.personal_tool_app.domain.animes.models.toEntity
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetStreamingEpisodeUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(episodeId: String): Flow<Resource<AnimeEpisodeStreaming>> = flow {
        val result = apiRepository
            .getEpisodeUrl(episodeId)
            .data?.toEntity()

        emit(Resource.Success(data = result))
    }

}