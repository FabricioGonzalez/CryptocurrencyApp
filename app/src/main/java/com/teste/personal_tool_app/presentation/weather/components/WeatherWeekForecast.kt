package com.teste.personal_tool_app.presentation.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherDayData
import com.teste.personal_tool_app.presentation.weather.states.WeatherState
import java.time.format.DateTimeFormatter

@Composable
fun WeatherWeekForecast(
    state: WeatherState,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer
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

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = modifier,
                backgroundColor = backgroundColor,
                shape =MaterialTheme.shapes.medium,
            ) {
                Column(
                    modifier = modifier
                ) {
                    Text(
                        text = "Weekly Forecast",
                        fontSize = 20.sp,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    list.map { weatherData ->
                        DaylyWeatherDisplay(
                            weatherData = weatherData,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = MaterialTheme.shapes.medium
                                ),
                            textColor = textColor
                        )
                    }
                }
            }
        }
    }
}