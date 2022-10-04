package com.teste.personal_tool_app.data.repositories.weather

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.mappers.weather.toWeatherInfo
import com.teste.personal_tool_app.data.remote.weather.WeatherApi
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherInfo
import com.teste.personal_tool_app.domain.weather.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}