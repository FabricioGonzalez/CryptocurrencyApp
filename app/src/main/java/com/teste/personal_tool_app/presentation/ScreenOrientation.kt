package com.teste.personal_tool_app.presentation

import android.content.pm.ActivityInfo

sealed class ScreenOrientation(val type: Int) {
    object Portrait : ScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    object Landscape : ScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
}