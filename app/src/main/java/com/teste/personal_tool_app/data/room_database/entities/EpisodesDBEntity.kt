package com.teste.personal_tool_app.data.room_database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "AnimeEpisodes",
    foreignKeys = [
        ForeignKey(
            entity = AnimeDBEntity::class,
            parentColumns = arrayOf("animeId"),
            childColumns = arrayOf("animeId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    primaryKeys = [
        "animeId",
        "episodeNumber"
    ]
)
data class EpisodesDBEntity(
    @ColumnInfo(name = "animeId")
    val animeId: String,
    @ColumnInfo(name = "episodeNumber")
    val episodeNumber: Int,
)