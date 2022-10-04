package com.teste.personal_tool_app.presentation.navigation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teste.personal_tool_app.presentation.MainActivity
import com.teste.personal_tool_app.presentation.Screen
import com.teste.personal_tool_app.presentation.coin.coin_detail.CoinDetailScreen
import com.teste.personal_tool_app.presentation.coin.coin_list.CoinListScreen
import com.teste.personal_tool_app.presentation.nofication.NotificationScreen
import com.teste.personal_tool_app.presentation.weather.WeatherForecast
import com.teste.personal_tool_app.presentation.weather.WeatherScreen
import com.teste.personal_tool_app.presentation.weather.viewmodels.WeatherViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    activity:MainActivity
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    )
    {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }
        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen()
        }
        composable(
            route = Screen.WeatherScreen.route
        ) {
            WeatherScreen(activity)
        }
    }

}