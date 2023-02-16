package com.teste.personal_tool_app.presentation.animes.anime_list.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.teste.personal_tool_app.presentation.animes.anime_list.viewmodels.AnimeListViewModel

@Composable

fun AnimeListView() {

    val viewModel = hiltViewModel<AnimeListViewModel>()

    val animes by viewModel.animeList.collectAsState()
    val keepWatching by viewModel.keepWatchingList.collectAsState()
    val topAiring by viewModel.topAiringList.collectAsState()

/*    LaunchedEffect(key1 = null) {

    }*/
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Animes", fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                Modifier
                    .fillMaxWidth()
            ) {
                items(animes) {
                    AnimeItem(item = it)
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Continue Watching", fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                Modifier
                    .fillMaxWidth()
            ) {
                items(
                    keepWatching
                ) {
                    KeepWatchingAnimeItem(item = it)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Top Airing Anime", fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            LazyRow(
                Modifier
                    .fillMaxWidth()
            ) {
                items(
                    topAiring
                ) {
                    TopAiringAnimeItem(item = it)
                }
            }
        }

    }
}

@Composable
@Preview
fun AnimeListPreview() {
    AnimeListView()
}