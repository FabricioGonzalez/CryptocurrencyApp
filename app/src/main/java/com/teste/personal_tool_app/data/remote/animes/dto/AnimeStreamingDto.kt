package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimeStreamingDto(
    val headers: HeadersDto,
    val sources: List<SourcesDto>,
    val download: String
)

data class HeadersDto(
    val Referer: String,
    val watchsb: String? = "", // or null, since only provided with server being equal to "streamsb".
    val userAgent: String? = "" // or null
)

data class SourcesDto(
    val url: String,
    val isM3U8: Boolean,
    val quality: String
)

/*
* "headers":{"Referer":"https://playgo1.cc/embedplus?id=MTg0MTQx&token=7CzVwh0rsvgy14Azaqc3kw&expires=1676493715"},
* "sources":[{"url":"https://wwwx12.gofcdn.com/videos/hls/BVGSStM_-Gp0q-NroOXjKQ/1676500915/184141/0789fd4f049c3ca2a49b860ea5d1f456/ep.1.1657688325.360.m3u8",
* "isM3U8":true,"quality":"360p"},
* "download":"https://gogohd.net/download?id=MTg0MTQx&token=7CzVwh0rsvgy14Azaqc3kw&expires=1676493715"}
* */