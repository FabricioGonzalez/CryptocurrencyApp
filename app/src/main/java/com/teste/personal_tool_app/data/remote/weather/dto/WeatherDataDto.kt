package com.teste.personal_tool_app.data.remote.weather.dto

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time: List<String?>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<String?>,
    @field:Json(name = "weathercode")
    val weatherCode: List<Int?>,
    @field:Json(name = "pressure_msl")
    val pressures: List<Double?>,
    @field:Json(name = "windspeed_10m")
    val windSpeeds: List<Double?>,
    @field:Json(name = "relativehumidity_2m")
    val humidities: List<Double?>
)
