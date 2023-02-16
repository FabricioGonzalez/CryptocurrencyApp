package com.teste.personal_tool_app.presentation.nofication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NotificationScreen(
    viewModel: NotificationViewModel = hiltViewModel(),

    ) {
    Box(modifier = Modifier.fillMaxSize()) {
        OutlinedButton(onClick = {
            viewModel.ShowNotification(0)
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Notifications")
        }
    }
}