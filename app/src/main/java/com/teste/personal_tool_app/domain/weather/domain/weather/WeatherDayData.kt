package com.teste.personal_tool_app.domain.weather.domain.weather

data class WeatherDayData(
    val minimumTemperatureCelsius: String,
    val maximumTemperatureCelsius: String,
    val day: String,
    val minimumPressure: Double,
    val MaximumPressure: Double,
    val minimumWindSpeed: Double,
    val maximumWindSpeed: Double,
    val minimumHumidity: Double,
    val maximumHumidity: Double,
    val weatherType: WeatherType
)