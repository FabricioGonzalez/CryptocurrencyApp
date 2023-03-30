package com.teste.personal_tool_app.data.room_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import com.teste.personal_tool_app.data.room_database.entities.WatchedEpisodesDBEntity

@Dao
interface EpisodesDAO {
    /* @Query(
         """
             SELECT * FROM
             WHERE videoId = :id
         """
     )
     fun loadLastWatchedEpisodes(): List<WatchedEpisodesDBEntity>*/

    @Transaction
    @Insert
    fun addLastWatchedEpisode(watchedEpisode: WatchedEpisodesDBEntity)
}