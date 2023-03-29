package com.teste.personal_tool_app.data.repositories.animes

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.remote.animes.AnimeApi
import com.teste.personal_tool_app.data.remote.animes.dto.*
import com.teste.personal_tool_app.domain.animes.enums.AnimeGenres
import com.teste.personal_tool_app.domain.animes.repositories.AnimeAPIRepository
import javax.inject.Inject

class AnimeAPIRepositoryImpl @Inject constructor(private val api: AnimeApi) : AnimeAPIRepository {
    override suspend fun getAnimes(): Resource<AnimePageEpisodeDto> {
        return try {
            val result = api.getAnimes()

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter animes recentes")
        }

    }

    override suspend fun getTopAiring(): Resource<AnimePageTopAiringDto> {
        return try {
            val result = api.getTopAiringAnimes()

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter top airing")
        }
    }

    override suspend fun getAnimeDetail(animeId: String): Resource<AnimeDetailsDto> {
        return try {
            val result = api.getAnimeDetails(animeId)

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter top airing")
        }
    }

    override suspend fun getEpisodeUrl(animeId: String): Resource<AnimeStreamingDto> {
        return try {
            val result = api.getAnimeEpisodeStreamingUrl(animeId)

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter top airing")
        }
    }

    override suspend fun getSearchedAnimes(
        keyword: String,
        page: Int
    ): Resource<AnimeSearchingPageDto> {
        return try {
            val result = api.getSearchedAnimes(animeId = keyword, page = page)

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter animes buscados")
        }
    }

    override suspend fun getAnimesByGenre(
        genres: AnimeGenres,
        page: Int
    ): Resource<GenreAnimePageDto> {
        return try {
            val result = api.getAnimesByGenre(genre = genres, page = page)

            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.localizedMessage ?: "Erro ao obter animes buscados")
        }
    }
}