package com.teste.personal_tool_app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            NotificationService.NOTIFICATION_CHANNEL_ID,
            "App",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "My App notifications"

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }
}