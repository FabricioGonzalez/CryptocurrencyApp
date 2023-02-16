package com.teste.personal_tool_app.data.remote.animes.dto

data class AnimePageDetailsDto(
    val currentPage: String,
    val hasNextPage: Boolean,
    val results: List<AnimeDetailsDto>
)

data class AnimeDetailsDto(
    val id: String,
    val title: String,
    val url: String,
    val genres: List<String>,
    val totalEpisodes: Int
)

/*
* "id":"spy-x-family",
* "title":"Spy x Family",
* "url":"/category/spy-x-family",
* "genres":["Action","Childcare","Comedy","Shounen"],
* "totalEpisodes":12,
* "image":"https://gogocdn.net/cover/spy-x-family.png",
* "releaseDate":"2022",
* "description":"For the agent known as \"Twilight,\" no order is too tall if it is for the sake of peace. Operating as Westalis' master spy, Twilight works tirelessly to prevent extremists from sparking a war with neighboring country Ostania. For his latest mission, he must investigate Ostanian politician Donovan Desmond by infiltrating his son's school: the prestigious Eden Academy. Thus, the agent faces the most difficult task of his career: get married, have a child, and play family.\n\nTwilight, or \"Loid Forger,\" quickly adopts the unassuming orphan Anya to play the role of a six-year-old daughter and prospective Eden Academy student. For a wife, he comes across Yor Briar, an absent-minded office worker who needs a pretend partner of her own to impress her friends. However, Loid is not the only one with a hidden nature. Yor moonlights as the lethal assassin \"Thorn Princess.\" For her, marrying Loid creates the perfect cover. Meanwhile, Anya is not the ordinary girl she appears to be; she is an esper, the product of secret experiments that allow her to read minds. Although she uncovers their true identities, Anya is thrilled that her new parents are cool secret agents! She would never tell them, of course. That would ruin the fun.\n\nUnder the guise of \"The Forgers,\" the spy, the assassin, and the esper must act as a family while carrying out their own agendas. Although these liars and misfits are only playing parts, they soon find that family is about far more than blood relations.",
* "subOrDub":"sub",
* "type":"SPRING 2022 ANIME",
* "status":"Completed",
* "otherName":"SPY×FAMILY",
* "episodes":[{"id":"spy-x-family-episode-1","number":1,"url":"https://www.gogoanime.dk//spy-x-family-episode-1"},
* {"id":"spy-x-family-episode-2",
* "number":2,
* "url":"https://www.gogoanime.dk//spy-x-family-episode-2"},{"id":"spy-x-family-episode-3","number":3,"url":"https://www.gogoanime.dk//spy-x-family-episode-3"},{"id":"spy-x-family-episode-4","number":4,"url":"https://www.gogoanime.dk//spy-x-family-episode-4"},{"id":"spy-x-family-episode-5","number":5,"url":"https://www.gogoanime.dk//spy-x-family-episode-5"},{"id":"spy-x-family-episode-6","number":6,"url":"https://www.gogoanime.dk//spy-x-family-episode-6"},{"id":"spy-x-family-episode-7","number":7,"url":"https://www.gogoanime.dk//spy-x-family-episode-7"},{"id":"spy-x-family-episode-8","number":8,"url":"https://www.gogoanime.dk//spy-x-family-episode-8"},{"id":"spy-x-family-episode-9","number":9,"url":"https://www.gogoanime.dk//spy-x-family-episode-9"},{"id":"spy-x-family-episode-10","number":10,"url":"https://www.gogoanime.dk//spy-x-family-episode-10"},{"id":"spy-x-family-episode-11","number":11,"url":"https://www.gogoanime.dk//spy-x-family-episode-11"},{"id":"spy-x-family-episode-12","number":12,
* "url":"https://www.gogoanime.dk//spy-x-family-episode-12"}]
* */