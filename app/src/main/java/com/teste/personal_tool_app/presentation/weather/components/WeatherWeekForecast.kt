package com.teste.personal_tool_app.presentation.weather.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.personal_tool_app.presentation.weather.states.WeatherState

@Composable
fun WeatherWeekForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    /*LazyRow(content = {
        items(state.weatherInfo.weatherDataPerDay) { weatherData ->
            HourlyWeatherDisplay(
                weatherData = weatherData,
                modifier = modifier
                    .height(100.dp)
                    .padding(horizontal = 16.dp),
                textColor = Color.White
            )
        }
    })*/

}