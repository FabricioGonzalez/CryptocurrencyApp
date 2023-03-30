package com.teste.personal_tool_app.data.room_database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "WatchedAnimeEpisodes",
    foreignKeys = [
        ForeignKey(
            entity = EpisodesDBEntity::class,
            parentColumns = arrayOf("episodeNumber", "animeId"),
            childColumns = arrayOf("episodeNumber", "animeId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    primaryKeys = [
        "animeId",
        "episodeNumber"
    ]
)
data class WatchedEpisodesDBEntity(
    @ColumnInfo(name = "animeId")
    val animeId: String,
    @ColumnInfo(name = "episodeNumber")
    val episodeNumber: Int,
    @ColumnInfo(name = "watchedTime")
    val watchedTime: Long,
    @ColumnInfo(name = "remainingTime")
    val remainingTime: Long
)