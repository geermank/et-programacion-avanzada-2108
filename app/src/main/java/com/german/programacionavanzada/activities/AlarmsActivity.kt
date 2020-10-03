package com.german.programacionavanzada.activities

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.german.programacionavanzada.R
import kotlinx.android.synthetic.main.activity_alarms.*
import java.util.*

class AlarmsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms)

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager // Jetpack -> WorkManager

        btn_ert_alarm.setOnClickListener {
            val alarmType = AlarmManager.ELAPSED_REALTIME_WAKEUP
            val triggerAtMillis = SystemClock.elapsedRealtime() + (1000 * 60)

            alarmManager.set(alarmType, triggerAtMillis, pendingIntent)
        }

        btn_rtc_alarm.setOnClickListener {
            val alarmType = AlarmManager.RTC_WAKEUP

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.HOUR, 18)
            calendar.set(Calendar.MINUTE, 30)

            alarmManager.setRepeating(alarmType, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
            // Picasso
        }

        btn_cancel_alarm.setOnClickListener {
            val previousIntent = Intent(this, MainActivity::class.java)
            val previousPendingIntent = PendingIntent.getActivity(
                this,
                0,
                previousIntent,
                PendingIntent.FLAG_NO_CREATE
            )

            if (previousPendingIntent != null) {
                alarmManager.cancel(previousPendingIntent)
            }
        }
    }
}
