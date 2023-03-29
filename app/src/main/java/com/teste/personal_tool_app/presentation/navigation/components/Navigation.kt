package com.teste.personal_tool_app.presentation.navigation.components

import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teste.personal_tool_app.common.Constants
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
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            CoinListScreen(navController)
        }
        composable(
            route = "${Screen.CoinDetailScreen.route}/{${Constants.PARAM_COIN_ID}}"
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            CoinDetailScreen()
        }
/*        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen()
        }*/
        composable(
            route = "${Screen.MangaScreen.route}/{${Constants.PARAM_MANGA_ID}}"
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            MangaScreen()
        }
        composable(
            route = "${Screen.MangaReaderScreen.route}/{${Constants.PARAM_MANGA_CHAPTER}}"
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            MangaReaderScreen()
        }
        composable(
            route = "${Screen.AnimePlayerScreen.route}/{${Constants.PARAM_ANIME_EPISODE_ID}}"
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            AnimePlayer()
        }
        composable(
            route = Screen.AnimeListScreen.route
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            AnimeListView(navController)
        }
        composable(
            route = "${Screen.AnimeDetailsScreen.route}/{${Constants.PARAM_ANIME_ID}}"
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            AnimeDetailsView(navController)
        }
        composable(
            route = Screen.MangaListScreen.route
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            MangaListScreen()
        }
        composable(
            route = Screen.WeatherScreen.route
        ) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            WeatherScreen(activity)
        }
    }

}