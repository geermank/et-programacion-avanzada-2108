package com.german.programacionavanzada

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat

class NotificationUtils {

    companion object {
        fun createNotification(
            context: Context,
            channelId: String,
            title: String,
            description: String
        ): Notification =
            NotificationCompat.Builder(context, channelId)
                .setContentTitle(title)
                .setContentText(description)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .build()
    }
}
