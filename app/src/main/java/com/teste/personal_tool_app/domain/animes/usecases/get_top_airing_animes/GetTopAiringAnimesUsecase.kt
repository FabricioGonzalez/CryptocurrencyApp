package com.teste.personal_tool_app.domain.animes.usecases.get_top_airing_animes

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.TopAiringAnime
import com.teste.personal_tool_app.domain.animes.models.toEntity
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopAiringAnimesUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(): Flow<Resource<List<TopAiringAnime>>> = flow {
        val result = apiRepository
            .getTopAiring()
            .data
            ?.results
            ?.map {
                it.toEntity()
            } ?: emptyList()

        emit(Resource.Success(data = result))
    }
}