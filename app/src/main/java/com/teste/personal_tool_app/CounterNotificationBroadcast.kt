package com.teste.personal_tool_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService

class CounterNotificationBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {

        val service = NotificationService(context)

        service.ShowNotification(++Counter.value)
    }
}