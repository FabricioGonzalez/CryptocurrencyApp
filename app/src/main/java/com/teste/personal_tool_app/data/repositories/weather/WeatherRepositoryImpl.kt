package com.teste.personal_tool_app.data.repositories.weather

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.remote.weather.WeatherApi
import com.teste.personal_tool_app.data.remote.weather.mappers.toWeatherInfo
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherInfo
import com.teste.personal_tool_app.domain.weather.repository.WeatherRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            val aQuarterOfWeek = LocalDate.now().plusDays(15)

            val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

            val startDate = LocalDate.now().withDayOfMonth(1).format(dateFormat)
            val endDate = aQuarterOfWeek.format(dateFormat)

            val result = api.getWeatherData(
                lat = lat,
                long = long,
                startDate = startDate,
                endDate = endDate
            ).toWeatherInfo()
            Resource.Success(
                data = result
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}