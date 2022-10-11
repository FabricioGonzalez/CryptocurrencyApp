package com.teste.personal_tool_app.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
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
    textColor: Color = Color.White
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Spacer(modifier = modifier.width(2.dp))
        Text(text = weatherData.day, color = Color.LightGray)
        Spacer(modifier = modifier.width(2.dp))
        Text(
            text = "min: ${weatherData.minimumTemperatureCelsius}°C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.width(2.dp))
        Text(
            text = "max: ${weatherData.maximumTemperatureCelsius}°C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}