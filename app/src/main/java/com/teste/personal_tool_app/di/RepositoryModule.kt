package com.teste.personal_tool_app.di

import com.teste.personal_tool_app.data.repositories.animes.AnimeRoomRepositoryImpl
import com.teste.personal_tool_app.data.repositories.weather.WeatherRepositoryImpl
import com.teste.personal_tool_app.data.room_database.DatabaseSpecs
import com.teste.personal_tool_app.domain.animes.repositories.AnimeDatabaseRepository
import com.teste.personal_tool_app.domain.weather.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun bindWeatherRepository(weatherRepository: WeatherRepositoryImpl): WeatherRepository {
        return weatherRepository
    }

    @Provides
    fun providesAnimeRoomDatabase(dbSpecs: DatabaseSpecs): AnimeDatabaseRepository {
        return AnimeRoomRepositoryImpl(dbSpecs)
    }

}