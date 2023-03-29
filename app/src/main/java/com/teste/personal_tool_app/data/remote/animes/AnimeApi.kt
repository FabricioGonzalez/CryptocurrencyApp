package com.teste.personal_tool_app.data.remote.animes

import com.teste.personal_tool_app.data.remote.animes.dto.*
import com.teste.personal_tool_app.domain.animes.enums.AnimeGenres
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApi {
    @GET("gogoanime/recent-episodes")
    suspend fun getAnimes(
        @Query("page") page: Int = 1,
        @Query("type") type: Int = 1
    ): AnimePageEpisodeDto

    @GET("gogoanime/info/{id}")
    suspend fun getAnimeDetails(
        @Path("id") animeId: String = "",
    ): AnimeDetailsDto

    @GET("gogoanime/{query}")
    suspend fun getSearchedAnimes(
        @Path("query") animeId: String = "",
        @Query("page") page: Int = 1,
    ): AnimeSearchingPageDto

    @GET("gogoanime/genre/{genreName}")
    suspend fun getAnimesByGenre(
        @Path("genreName") genre: AnimeGenres,
        @Query("page") page: Int = 1,
    ): GenreAnimePageDto

    @GET("gogoanime/watch/{id}")
    suspend fun getAnimeEpisodeStreamingUrl(
        @Path("id") episodeId: String = "",
        /*@Query("server") serverName: String = "gogocdn"*/
    ): AnimeStreamingDto

    @GET("gogoanime/top-airing")
    suspend fun getTopAiringAnimes(@Query("page") page: Int = 1): AnimePageTopAiringDto


}