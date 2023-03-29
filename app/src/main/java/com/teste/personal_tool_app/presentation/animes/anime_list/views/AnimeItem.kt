package com.teste.personal_tool_app.presentation.animes.anime_list.views

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teste.personal_tool_app.data.remote.animes.dto.AnimeEpisodeDto
import com.teste.personal_tool_app.presentation.components.ImageLoader


data class DropDownItem<in T>(
    val text: String,
    val onClickAction: (param: T) -> Unit,
    val icon: ImageVector? = null
)

@Composable
fun <T> ItemBox(
    modifier: Modifier = Modifier,
    dropDownItems: List<DropDownItem<T>>,
    onClickAction: () -> Unit = {},
    cardColors: CardColors = CardDefaults.cardColors(),
    item: T,
    displayItem: @Composable () -> Unit
) {
    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }
    var itemHeight by remember {
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current

    val interactionSource = remember {
        MutableInteractionSource()
    }
    Card(
        modifier = modifier.onSizeChanged {
            itemHeight = with(density) { it.height.toDp() }
        },
        colors = cardColors
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .indication(
                interactionSource = interactionSource,
                indication = LocalIndication.current
            )
            .pointerInput(true) {
                detectTapGestures(onLongPress = {
                    isContextMenuVisible = true
                    pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                },
                    onDoubleTap = {
                        onClickAction()
                    }, onPress = {
                        val press = PressInteraction.Press(it)
                        interactionSource.emit(press)
                        tryAwaitRelease()
                        interactionSource.emit(PressInteraction.Release(press))
                    })
            }
            .clip(shape = MaterialTheme.shapes.medium)
        ) {
            displayItem()
            DropdownMenu(
                expanded = isContextMenuVisible,
                onDismissRequest = { isContextMenuVisible = false },
                offset = pressOffset.copy(
                    y = pressOffset.y - itemHeight
                )
            ) {
                dropDownItems.forEach { dropDownItem ->
                    DropdownMenuItem(onClick = {
                        dropDownItem.onClickAction(item)
                        isContextMenuVisible = false
                    }) {
                        Text(
                            text = dropDownItem.text,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnimeItem(
    modifier: Modifier = Modifier,
    item: AnimeEpisodeDto
) {
    Column(
        modifier = modifier
            .width(164.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        ImageLoader(
            modifier = modifier
                .fillMaxWidth()
                .height(232.dp)
                .clip(MaterialTheme.shapes.small),
            imageLink = item.image,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = modifier.height(4.dp))

        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = "Episode ${item.episodeNumber}",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}