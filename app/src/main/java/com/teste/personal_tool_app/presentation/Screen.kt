package com.teste.personal_tool_app.presentation

sealed class Screen(val route:String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")
    object MangaListScreen : Screen("manga_list_screen")
    object MangaScreen : Screen("manga_screen")
    object MangaReaderScreen : Screen("manga_reader_screen")

    /*object NotificationScreen : Screen("notification_screen")*/
    object WeatherScreen : Screen("weather_screen")
}
