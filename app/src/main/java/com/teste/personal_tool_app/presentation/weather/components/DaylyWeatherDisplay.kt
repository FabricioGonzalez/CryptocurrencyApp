package com.teste.personal_tool_app.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.teste.personal_tool_app.domain.weather.domain.weather.WeatherDayData

@Composable
fun DaylyWeatherDisplay(
    weatherData: WeatherDayData,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(126.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            Image(
                painter = painterResource(id = weatherData.weatherType.iconRes),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(text = weatherData.day, color = textColor)
        }
        Spacer(modifier = Modifier.width(2.dp))
        Column {
            Text(
                text = "min: ${weatherData.minimumTemperatureCelsius}°C",
                color = textColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "max: ${weatherData.maximumTemperatureCelsius}°C",
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}