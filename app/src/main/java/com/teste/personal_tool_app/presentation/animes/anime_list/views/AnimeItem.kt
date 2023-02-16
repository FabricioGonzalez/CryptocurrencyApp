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
import androidx.compose.ui.unit.dp
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeDto
import com.teste.personal_tool_app.presentation.components.ImageLoader

@Composable
fun AnimeItem(item: AnimeDto, onClickAction: () -> Unit = {}) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
            .clickable {
                onClickAction()
            }
    ) {
        ImageLoader(
            modifier = Modifier
                .width(164.dp)
                .height(232.dp)
                .clip(RoundedCornerShape(10.dp)),
            imageLink = item.image,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(item.title)
    }
}