package com.teste.personal_tool_app.data.room_database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Animes")
data class AnimeDBEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "animeId")
    val animeId: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,
    @ColumnInfo(name = "subOrDub")
    val subOrDub: String
)
