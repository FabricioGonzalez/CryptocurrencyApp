package com.teste.personal_tool_app.presentation.animes.anime_list.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeEpisodeDto
import com.teste.personal_tool_app.presentation.components.ImageLoader

@Composable
fun KeepWatchingAnimeItem(item: AnimeEpisodeDto, onClickAction: () -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .width(248.dp)
            .padding(8.dp)
            .clickable {
                onClickAction()
            }
    ) {
        ImageLoader(
            modifier = Modifier
                .fillMaxWidth()
                .height(164.dp)
                .clip(RoundedCornerShape(10.dp)),
            imageLink = item.image,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(item.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Text("Episode ${item.episodeNumber}")
    }
}