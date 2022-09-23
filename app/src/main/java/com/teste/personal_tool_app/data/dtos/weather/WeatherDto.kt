package com.teste.personal_tool_app.data.dtos.weather

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name="hourly")
    val weatherData: WeatherDataDto
)