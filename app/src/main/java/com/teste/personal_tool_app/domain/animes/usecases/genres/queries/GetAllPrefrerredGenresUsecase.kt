package com.teste.personal_tool_app.domain.animes.usecases.genres.queries

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.animes.models.AnimeGenre
import com.teste.personal_tool_app.domain.animes.repositories.AnimeDatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPrefrerredGenresUsecase @Inject constructor(
    private val animeDatabase: AnimeDatabaseRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<AnimeGenre>>> = flow {
        try {
            emit(Resource.Loading(isLoading = true))

            val result = animeDatabase.getAllGenres()
            
            emit(Resource.Success(data = result))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage, null))
        }
    }
}