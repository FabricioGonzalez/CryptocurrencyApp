package com.teste.personal_tool_app.presentation.animes.anime_details.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.teste.personal_tool_app.presentation.Screen
import com.teste.personal_tool_app.presentation.animes.anime_details.viewmodels.AnimeDetailsViewModel

@Composable
fun AnimeEpisodeScreen(detailsViewModel: AnimeDetailsViewModel, navController: NavController) {

    val animeData by detailsViewModel.anime.collectAsState()

    LazyColumn {
        animeData?.let { anime ->
            items(anime.episodes) {
                AnimeEpisodeItem(episode = it) {
                    navController.navigate(Screen.AnimePlayerScreen.route + "/${it.id}")
                }
            }
        }
    }
}