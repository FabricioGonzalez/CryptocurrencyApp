package com.teste.personal_tool_app.presentation.nofication

import androidx.lifecycle.ViewModel

import com.teste.personal_tool_app.presentation.nofication.services.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(private val notification: NotificationService) :
    ViewModel() {
    fun ShowNotification(counter: Int) {
        notification.ShowNotification(counter)
    }
}
