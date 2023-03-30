package com.teste.personal_tool_app.data.room_database.dao

import androidx.room.Dao
import androidx.room.Query
import com.teste.personal_tool_app.data.room_database.entities.AnimeGenreDBEntity

@Dao
interface GenreDAO {

    @Query("Select * from Genres")
    fun getAllGenres(): List<AnimeGenreDBEntity>
}