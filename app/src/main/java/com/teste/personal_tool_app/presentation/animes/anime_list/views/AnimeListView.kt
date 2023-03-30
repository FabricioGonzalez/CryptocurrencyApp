package com.teste.personal_tool_app.presentation.animes.anime_list.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.teste.personal_tool_app.presentation.Screen
import com.teste.personal_tool_app.presentation.animes.anime_list.viewmodels.AnimeListViewModel

@Composable

fun AnimeListView(navController: NavController) {

    val viewModel = hiltViewModel<AnimeListViewModel>()

    val animes by viewModel.animeList.collectAsState()
    val keepWatching by viewModel.keepWatchingList.collectAsState()
    val topAiring by viewModel.topAiringList.collectAsState()
    val searchingAnimes by viewModel.seachingList.collectAsState()
    val animeByGenre by viewModel.genreFilteredAnimes.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.onPrimary
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                )
                .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = Dp.Hairline)
        ) {
            TextField(
                modifier = Modifier.fillMaxSize(),
                value = searchText,
                onValueChange = viewModel::searchAnimes,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colorScheme.onSurface,
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.15f),
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    trailingIconColor = MaterialTheme.colorScheme.onSurface
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        modifier = Modifier.clickable {
                            viewModel.searchAnimes(searchText)
                        }
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        if (!isSearching) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f))
                    .padding(4.dp)
            ) {
                if (animes.isNotEmpty()) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                contentColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                disabledContainerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.1f
                                ),
                            ),
                            elevation = CardDefaults.elevatedCardElevation(4.dp),
                        ) {
                            Column(horizontalAlignment = { _, _, _ ->
                                20.dp.value.toInt()
                            }) {
                                Text(
                                    modifier = Modifier,
                                    text = "Animes",
                                    fontStyle = FontStyle.Normal,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )


                                Spacer(modifier = Modifier.height(4.dp))

                                LazyRow(
                                    Modifier
                                        .fillMaxWidth(),
                                    contentPadding = PaddingValues(2.dp, 2.dp),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    items(items = animes) { recentAnime ->
                                        ItemBox(
                                            cardColors = CardDefaults.elevatedCardColors(
                                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                                contentColor = MaterialTheme.colorScheme.primaryContainer,
                                                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                                                    alpha = 0.1f
                                                ),
                                            ),
                                            dropDownItems = listOf(
                                                DropDownItem(
                                                    text = "Adicionar à minha lista",
                                                    { actionItem ->
                                                        Toast.makeText(
                                                            context,
                                                            actionItem.title,
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    })
                                            ),
                                            item = recentAnime,
                                            onClickAction = {
                                                navController.navigate(Screen.AnimeDetailsScreen.route + "/${recentAnime.id}")
                                            }
                                        ) {
                                            AnimeItem(item = recentAnime)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (keepWatching.isNotEmpty()) {
                    item {
                        Card(
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                contentColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                disabledContainerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.1f
                                ),
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            elevation = CardDefaults.elevatedCardElevation(4.dp)
                        ) {
                            Column(horizontalAlignment = { _, _, _ ->
                                20.dp.value.toInt()
                            }) {
                                Text(
                                    text = "Continue Watching",
                                    fontStyle = FontStyle.Normal,
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                LazyRow(
                                    Modifier
                                        .fillMaxWidth(),
                                    contentPadding = PaddingValues(2.dp, 2.dp),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    items(
                                        items = keepWatching
                                    ) { keepWatchingAnime ->
                                        ItemBox(
                                            cardColors = CardDefaults.elevatedCardColors(
                                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                                contentColor = MaterialTheme.colorScheme.primaryContainer,
                                                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                                                    alpha = 0.1f
                                                ),
                                            ),
                                            dropDownItems = listOf(
                                                DropDownItem(
                                                    text = "Adicionar à minha lista",
                                                    { actionItem ->
                                                        Toast.makeText(
                                                            context,
                                                            actionItem.title,
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    })
                                            ),
                                            item = keepWatchingAnime,
                                            onClickAction = {
                                                navController.navigate(
                                                    Screen.AnimeDetailsScreen.route
                                                            + "/${keepWatchingAnime.id}"
                                                )
                                            }
                                        ) {
                                            KeepWatchingAnimeItem(item = keepWatchingAnime)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (topAiring.isNotEmpty()) {
                    item {
                        Card(
                            colors = CardDefaults.elevatedCardColors(
                                containerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                contentColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                ),
                                disabledContainerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.1f
                                ),
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            elevation = CardDefaults.elevatedCardElevation(4.dp)
                        ) {
                            Column(horizontalAlignment = { _, _, _ ->
                                20.dp.value.toInt()
                            }) {
                                Text(
                                    text = "Top Airing Anime",
                                    fontStyle = FontStyle.Normal,
                                    fontSize = 24.sp,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                LazyRow(
                                    Modifier
                                        .fillMaxWidth(),
                                    contentPadding = PaddingValues(2.dp, 2.dp),
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    items(
                                        items = topAiring
                                    ) { topAiringAnime ->
                                        ItemBox(
                                            cardColors = CardDefaults.elevatedCardColors(
                                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                                contentColor = MaterialTheme.colorScheme.primaryContainer,
                                                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(
                                                    alpha = 0.1f
                                                ),
                                            ),
                                            dropDownItems = listOf(
                                                DropDownItem(
                                                    text = "Adicionar à minha lista",
                                                    { actionItem ->
                                                        Toast.makeText(
                                                            context,
                                                            actionItem.title,
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    })
                                            ),
                                            item = topAiringAnime,
                                            onClickAction = {
                                                navController.navigate(
                                                    Screen.AnimeDetailsScreen.route
                                                            + "/${topAiringAnime.id}"
                                                )
                                            }
                                        ) {
                                            TopAiringAnimeItem(item = topAiringAnime)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            LazyVerticalGrid(
                contentPadding = PaddingValues(4.dp, 4.dp),
                columns = GridCells.Adaptive(164.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = searchingAnimes) { searchingItem ->
                    ItemBox(
                        dropDownItems = listOf(
                            DropDownItem(
                                text = "Adicionar à minha lista",
                                { actionItem ->
                                    Toast.makeText(
                                        context,
                                        actionItem.title,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                })
                        ),
                        item = searchingItem,
                        onClickAction = {
                            navController.navigate(Screen.AnimeDetailsScreen.route + "/${searchingItem.id}")
                        }
                    ) {
                        SearchingAnimeItem(item = searchingItem)
                    }
                }
            }
        }

    }
}