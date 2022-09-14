package com.teste.personal_tool_app.presentation.nofication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.teste.personal_tool_app.Counter
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService

@Composable
fun NotificationScreen(
    viewModel: NotificationViewModel = hiltViewModel(),

) {
    Box(modifier = Modifier.fillMaxSize()) {
        OutlinedButton(onClick = {
            viewModel.ShowNotification(Counter.value)
        }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "Notifications")
        }
    }
}