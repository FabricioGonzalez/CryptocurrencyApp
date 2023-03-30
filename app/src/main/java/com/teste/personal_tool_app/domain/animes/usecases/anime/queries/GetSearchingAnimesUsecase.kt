package com.teste.personal_tool_app.domain.animes.usecases.anime.queries

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeSearching
import com.teste.personal_tool_app.domain.animes.models.toEntity
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetSearchingAnimesUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(searching: String, page: Int = 1): Flow<Resource<List<AnimeSearching>>> =
        flow {
            val result = apiRepository
                .getSearchedAnimes(keyword = searching, page = page)
                .data
                ?.results
                ?.map {
                    it.toEntity()
                } ?: emptyList()

            emit(Resource.Success(data = result))
        }
}