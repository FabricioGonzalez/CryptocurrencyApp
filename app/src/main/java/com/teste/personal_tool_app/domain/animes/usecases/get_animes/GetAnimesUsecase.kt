package com.teste.personal_tool_app.domain.animes.usecases.get_animes

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeDetails
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

class GetAnimeDetailsUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(animeId: String): Flow<Resource<AnimeDetails>> = flow {
        val result = apiRepository
            .getAnimeDetail(animeId)
            .data?.toEntity()

        emit(Resource.Success(data = result))
    }
}