package com.teste.personal_tool_app.presentation.animes.anime_details.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.teste.personal_tool_app.domain.animes.models.AnimeDetailsEpisode

@Composable
fun AnimeEpisodeItem(
    modifier: Modifier = Modifier,
    episode: AnimeDetailsEpisode,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    onClickAction: () -> Unit = {}
) {
    Row(
        modifier
            .clickable {
                onClickAction()
            }
            .padding(4.dp)) {
        Row() {
            Text(text = "Episode", color = textColor)
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "${episode.number}", color = textColor)
        }
    }
}