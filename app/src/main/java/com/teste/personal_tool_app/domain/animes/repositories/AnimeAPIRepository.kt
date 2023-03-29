package com.teste.personal_tool_app.domain.animes.repositories

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.remote.animes.dto.*
import com.teste.personal_tool_app.domain.animes.enums.AnimeGenres

interface AnimeAPIRepository {

    suspend fun getAnimes(): Resource<AnimePageEpisodeDto>
    suspend fun getTopAiring(): Resource<AnimePageTopAiringDto>
    suspend fun getAnimeDetail(animeId: String): Resource<AnimeDetailsDto>
    suspend fun getEpisodeUrl(animeId: String): Resource<AnimeStreamingDto>
    suspend fun getSearchedAnimes(keyword: String, page: Int = 1): Resource<AnimeSearchingPageDto>
    suspend fun getAnimesByGenre(genres: AnimeGenres, page: Int = 1): Resource<GenreAnimePageDto>

}