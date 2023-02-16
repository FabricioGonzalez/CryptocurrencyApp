package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimePageTopAiringDto(
    val currentPage: String,
    val hasNextPage: Boolean,
    val results: List<TopAiringAnimeDto>
)

data class TopAiringAnimeDto(
    val id: String,
    val title: String,
    val image: String,
    val url: String,
    val genres: List<String>
)

/*
"currentPage":1,
"hasNextPage":true,
"results":
{
* "id":"vinland-saga-season-2",
* "title":"Vinland Saga Season 2",
* "image":"https://gogocdn.net/cover/vinland-saga-season-2-1672333695.png",
* "url":"https://www.gogoanime.dk/category/vinland-saga-season-2",
* "genres":["Action","Adventure","Drama","Gore","Seinen"]}
* */