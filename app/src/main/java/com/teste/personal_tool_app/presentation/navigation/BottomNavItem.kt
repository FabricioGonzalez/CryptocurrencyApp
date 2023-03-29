package com.teste.personal_tool_app.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.teste.personal_tool_app.presentation.ScreenOrientation

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
    val hideBottomBar: Boolean = false,
    val hidden: Boolean = false,
    val Orientation: ScreenOrientation = ScreenOrientation.Portrait
)
