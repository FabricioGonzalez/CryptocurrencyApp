package com.teste.personal_tool_app.presentation.navigation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teste.personal_tool_app.presentation.MainActivity
import com.teste.personal_tool_app.presentation.Screen
import com.teste.personal_tool_app.presentation.coin.coin_detail.CoinDetailScreen
import com.teste.personal_tool_app.presentation.coin.coin_list.CoinListScreen
import com.teste.personal_tool_app.presentation.manga.MangaScreen
import com.teste.personal_tool_app.presentation.manga.manga_list.MangaListScreen
import com.teste.personal_tool_app.presentation.manga.manga_reader.MangaReaderScreen
import com.teste.personal_tool_app.presentation.weather.WeatherScreen

@Composable
fun Navigation(
    navController: NavHostController,
    activity: MainActivity
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
/*        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen()
        }*/
        composable(
            route = Screen.MangaScreen.route + "/{mangaUrl}"
        ) {
            MangaScreen()
        }
        composable(
            route = Screen.MangaReaderScreen.route + "/{mangaChapter}"
        ) {
            MangaReaderScreen()
        }
        composable(
            route = Screen.MangaListScreen.route
        ) {
            MangaListScreen()
        }
        composable(
            route = Screen.WeatherScreen.route
        ) {
            WeatherScreen(activity)
        }
    }

}