package com.teste.personal_tool_app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import com.teste.personal_tool_app.common.Constants
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
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
}