package com.teste.personal_tool_app.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.teste.personal_tool_app.presentation.MainActivity
import com.teste.personal_tool_app.presentation.weather.components.WeatherCard
import com.teste.personal_tool_app.presentation.weather.components.WeatherForecast
import com.teste.personal_tool_app.presentation.weather.components.WeatherWeekForecast
import com.teste.personal_tool_app.presentation.weather.viewmodels.WeatherViewModel

@Composable
fun WeatherScreen(
    activity: MainActivity,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadWeatherInfo()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
                .padding(4.dp)
        ) {
            if (viewModel.state.weatherInfo != null) {
                WeatherCard(
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    state = viewModel.state,
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer
                )
                Spacer(modifier = Modifier.height(4.dp))
                WeatherForecast(
                    state = viewModel.state
                )
                Spacer(modifier = Modifier.height(4.dp))
                WeatherWeekForecast(
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    state = viewModel.state,
                    backgroundColor = MaterialTheme.colorScheme.surface
                )
            }
        }
        if (viewModel.state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.primary
            )
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error, color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


