package com.teste.personal_tool_app.presentation.weather.states

import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)