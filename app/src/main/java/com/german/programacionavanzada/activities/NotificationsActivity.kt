package com.german.programacionavanzada.activities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import com.german.programacionavanzada.R
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        btn_show_notification.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        val intent = Intent(this, UsersActivity::class.java)
        //val pendingIntent = PendingIntent.getActivity(this, 11, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val taskBuilder = TaskStackBuilder.create(this)
        taskBuilder.addNextIntentWithParentStack(intent)

        val pendingIntent = taskBuilder.getPendingIntent(11, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, "ofertas_id")
            .setContentTitle("Ofertas de la semana!")
            .setContentText("Apurate que se acaban!")
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("ofertas_id", "Ofertas", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(1, builder.build())
    }
}