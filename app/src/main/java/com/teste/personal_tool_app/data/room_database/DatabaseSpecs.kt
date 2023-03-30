package com.teste.personal_tool_app.data.room_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teste.personal_tool_app.data.room_database.dao.AnimeDAO
import com.teste.personal_tool_app.data.room_database.dao.EpisodesDAO
import com.teste.personal_tool_app.data.room_database.dao.GenreDAO
import com.teste.personal_tool_app.data.room_database.entities.*

@Database(
    entities = [
        AnimeDBEntity::class,
        EpisodesDBEntity::class,
        WatchedEpisodesDBEntity::class,
        AnimeGenreDBEntity::class,
        PreferredGenreDBEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class DatabaseSpecs : RoomDatabase() {
    abstract fun animeDAO(): AnimeDAO
    abstract fun episodesDAO(): EpisodesDAO
    abstract fun genreDAO(): GenreDAO
}