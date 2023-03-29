package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimePageDto(
    val currentPage: String,
    val hasNextPage: Boolean,
    val results: List<AnimeDto>
)

data class AnimeDto(
    val id: String,
    val title: String,
    val url: String,
    val image: String,
    val releaseDate: String,
    val subOrDub: String
)


/*
* {"id":"kishin-douji-zenki",
* "title":"Kishin Douji Zenki",
* "url":"https://www.gogoanime.dk//category/kishin-douji-zenki",
* "image":"https://gogocdn.net/cover/kishin-douji-zenki.png",
* "releaseDate":
* "Released: 1995",
* "subOrDub":"sub"}
* */
