package com.teste.personal_tool_app.presentation.animes.anime_details.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teste.personal_tool_app.presentation.animes.anime_details.viewmodels.AnimeDetailsViewModel
import com.teste.personal_tool_app.presentation.components.ImageLoader


enum class Tabs {
    Info,
    Episodes
}

@Composable
fun AnimeDetailsView(navController: NavController) {


    val tab = remember { mutableStateOf(Tabs.Info) }
    val tabTitles = Tabs.values().map { it.name }
    val viewModel: AnimeDetailsViewModel = hiltViewModel()

    val animeData by viewModel.anime.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            animeData?.let { anime ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ImageLoader(
                        modifier = Modifier
                            .width(164.dp)
                            .height(232.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        imageLink = anime.image,
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = anime.title, color = MaterialTheme.colorScheme.onPrimaryContainer)

                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            TabRow(
                selectedTabIndex = tab.value.ordinal,
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                tabTitles.forEach { title ->
                    Tab(text = {
                        Text(
                            title,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    },
                        selected = tab.value == Tabs.valueOf(title),
                        onClick = { tab.value = Tabs.valueOf(title) }
                    )
                }
            }
            when (tab.value.ordinal) {
                0 -> AnimeInfoScreen(viewModel)
                1 -> AnimeEpisodeScreen(viewModel, navController = navController)
            }
        }
    }
}