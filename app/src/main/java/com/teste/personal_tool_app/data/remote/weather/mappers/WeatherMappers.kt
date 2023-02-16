package com.teste.personal_tool_app.data.remote.weather.mappers

import com.teste.personal_tool_app.data.remote.weather.dto.WeatherDataDto
import com.teste.personal_tool_app.data.remote.weather.dto.WeatherDto
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherData
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherInfo
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCode[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                humidity = humidity ?: 0.0,
                weatherType = WeatherType.fromWMO(weatherCode ?: 0),
                pressure = pressure ?: 0.0,
                windSpeed = windSpeed ?: 0.0,
                temperatureCelsius = temperature ?: "0"
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map { item ->
            item.data
        }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(weatherDataMap, currentWeatherData)
}