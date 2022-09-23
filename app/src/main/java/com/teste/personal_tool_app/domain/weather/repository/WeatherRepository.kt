package com.teste.personal_tool_app.domain.weather.repository

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,long:Double): Resource<WeatherInfo>
}