package com.teste.personal_tool_app.presentation.animes.anime_list.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.teste.personal_tool_app.data.remote.animes.dto.TopAiringAnimeDto
import com.teste.personal_tool_app.presentation.components.ImageLoader

@Composable
fun TopAiringAnimeItem(
    item: TopAiringAnimeDto
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
    ) {
        ImageLoader(
            modifier = Modifier
                .fillMaxWidth()
                .height(232.dp)
                .clip(MaterialTheme.shapes.medium),
            imageLink = item.image,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}