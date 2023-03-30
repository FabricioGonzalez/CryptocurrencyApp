package com.teste.personal_tool_app.data.room_database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teste.personal_tool_app.domain.animes.models.AnimeGenre

@Entity(tableName = "Genres")
data class AnimeGenreDBEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "genreId")
    val genreId: Int,
    @ColumnInfo(name = "name")
    val name: String
)

fun AnimeGenreDBEntity.toEntity(): AnimeGenre {
    return AnimeGenre(
        genreId = genreId,
        name = name
    )
}

fun AnimeGenre.ToDto(): AnimeGenreDBEntity {
    return AnimeGenreDBEntity(
        genreId = genreId,
        name = name
    )
}