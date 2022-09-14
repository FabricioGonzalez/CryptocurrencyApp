package com.teste.personal_tool_app.presentation.nofication.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.teste.personal_tool_app.CounterNotificationBroadcast
import com.teste.personal_tool_app.R
import com.teste.personal_tool_app.presentation.MainActivity
import javax.inject.Inject

class NotificationService @Inject constructor(
    private val context: Context,
) {
    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun ShowNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context, 1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(
                context, CounterNotificationBroadcast::class.java,
            ),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val notification =
            NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_round_app_shortcut_24)
                .setContentTitle("App Local Notification")
                .setContentText("counter: $counter")
                /* .setStyle(
                     NotificationCompat.BigTextStyle()
                 )*/
                .setContentIntent(activityPendingIntent)
                .addAction(
                    R.drawable.ic_round_app_shortcut_24,
                    "Increment",
                    incrementIntent
                )
                .build()
        notificationManager.notify(1, notification)

    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "counter_channel"
    }
}