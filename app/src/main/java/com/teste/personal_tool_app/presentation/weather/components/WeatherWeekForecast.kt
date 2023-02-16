package com.teste.personal_tool_app.presentation.weather.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherDayData
import com.teste.personal_tool_app.presentation.weather.states.WeatherState
import java.time.format.DateTimeFormatter

@Composable
fun WeatherWeekForecast(
    state: WeatherState, backgroundColor: Color, modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay.let { items ->
        val list: MutableList<WeatherDayData> = mutableListOf()
        items?.keys?.forEach { day ->
            val result = items[day]?.sortedBy { item ->
                item.temperatureCelsius
            }

            val first = result?.first()
            val last = result?.last()

            if (first != null && last != null) {
                val formattedTime = remember(first) {
                    first.time.format(
                        DateTimeFormatter.ofPattern("dd/MM")
                    )
                }
                val weatherData = WeatherDayData(
                    maximumHumidity = last.humidity,
                    MaximumPressure = last.pressure,
                    maximumTemperatureCelsius = last.temperatureCelsius,
                    maximumWindSpeed = last.windSpeed,
                    minimumHumidity = first.humidity,
                    minimumPressure = first.pressure,
                    minimumTemperatureCelsius = first.temperatureCelsius,
                    minimumWindSpeed = first.windSpeed,
                    weatherType = first.weatherType,
                    day = formattedTime
                )
                list.add(weatherData)
            }
        }
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = modifier
            ) {
                Text(
                    text = "Weekly Forecast", fontSize = 20.sp, color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                list.map { weatherData ->
                    DaylyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = modifier
                            .padding(16.dp),
                        textColor = Color.White
                    )
                }
            }
        }
    }
}