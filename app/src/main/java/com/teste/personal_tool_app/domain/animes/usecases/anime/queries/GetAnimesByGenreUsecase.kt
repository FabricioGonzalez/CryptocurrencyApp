package com.teste.personal_tool_app.domain.animes.usecases.anime.queries

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeGenre
import com.teste.personal_tool_app.domain.animes.models.GenreAnime
import com.teste.personal_tool_app.domain.animes.models.toEntity
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAnimesByGenreUsecase @Inject constructor(
    private val apiRepository: AnimeAPIRepository
) {
    operator fun invoke(genres: AnimeGenre, page: Int = 1): Flow<Resource<List<GenreAnime>>> =
        flow {
            val result = apiRepository
                .getAnimesByGenre(genres.name, page)
                .data
                ?.results
                ?.map {
                    it.toEntity()
                } ?: emptyList()

            emit(Resource.Success(data = result))
        }
}