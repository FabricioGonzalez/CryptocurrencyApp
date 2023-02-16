package com.teste.personal_tool_app.presentation.navigation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teste.personal_tool_app.presentation.MainActivity
import com.teste.personal_tool_app.presentation.Screen
import com.teste.personal_tool_app.presentation.animes.anime_details.views.AnimeDetailsView
import com.teste.personal_tool_app.presentation.animes.anime_list.views.AnimeListView
import com.teste.personal_tool_app.presentation.animes.anime_player.views.AnimePlayer
import com.teste.personal_tool_app.presentation.coin.coin_detail.CoinDetailScreen
import com.teste.personal_tool_app.presentation.coin.coin_list.CoinListScreen
import com.teste.personal_tool_app.presentation.manga.MangaScreen
import com.teste.personal_tool_app.presentation.manga.manga_list.MangaListScreen
import com.teste.personal_tool_app.presentation.manga.manga_reader.MangaReaderScreen
import com.teste.personal_tool_app.presentation.weather.WeatherScreen

@Composable
fun Navigation(
    navController: NavHostController,
    activity: MainActivity,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AnimeListScreen.route,
        modifier = modifier
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
            route = Screen.AnimePlayerScreen.route
        ) {
            AnimePlayer()
        }
        composable(
            route = Screen.AnimeListScreen.route
        ) {
            AnimeListView()
        }
        composable(
            route = Screen.AnimeDetailsScreen.route + "/{animeId}"
        ) {
            AnimeDetailsView()
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