package com.teste.personal_tool_app.data.room_database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "PreferredGenres", foreignKeys = [
        ForeignKey(
            entity = AnimeGenreDBEntity::class,
            childColumns = arrayOf("genreId"),
            parentColumns = arrayOf("genreId"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class PreferredGenreDBEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "preferredGenreId")
    val preferredGenreId: Int,

    @ColumnInfo(name = "genreId")
    val genreId: Int
)
