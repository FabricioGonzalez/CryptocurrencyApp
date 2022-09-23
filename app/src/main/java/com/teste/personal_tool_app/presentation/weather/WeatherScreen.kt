package com.teste.personal_tool_app.presentation.weather

import android.Manifest
import android.content.Context
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.teste.personal_tool_app.presentation.MainActivity
import com.teste.personal_tool_app.presentation.theme.DarkBlue
import com.teste.personal_tool_app.presentation.theme.DeepBlue
import com.teste.personal_tool_app.presentation.weather.components.WeatherCard
import com.teste.personal_tool_app.presentation.weather.components.WeatherWeekForecast
import com.teste.personal_tool_app.presentation.weather.viewmodels.WeatherViewModel

@Composable
fun WeatherScreen(
    activity: MainActivity,
    viewModel: WeatherViewModel = hiltViewModel()
){
    LaunchedEffect(Unit){
        viewModel.loadWeatherInfo()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
        ) {
            WeatherCard(state = viewModel.state, backgroundColor = DeepBlue)
            Spacer(modifier = Modifier.height(16.dp))
            WeatherForecast(state = viewModel.state)
            WeatherWeekForecast(state = viewModel.state)
        }
        if (viewModel.state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error, color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


