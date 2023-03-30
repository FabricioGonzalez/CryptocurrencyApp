package com.teste.personal_tool_app.domain.animes.usecases.anime.queries

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeEpisode
import com.teste.personal_tool_app.domain.animes.models.toEntity
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetAnimesUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(): Flow<Resource<List<AnimeEpisode>>> = flow {
        val result = apiRepository
            .getAnimes()
            .data
            ?.results
            ?.map {
                it.toEntity()
            } ?: emptyList()

        emit(Resource.Success(data = result))
    }

}

