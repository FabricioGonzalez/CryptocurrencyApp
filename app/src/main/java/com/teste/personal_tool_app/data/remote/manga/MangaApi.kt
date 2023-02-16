package com.teste.personal_tool_app.data.remote.manga

import com.teste.personal_tool_app.data.remote.weather.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApi {
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
    ): WeatherDto
}