package com.german.programacionavanzada.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.german.programacionavanzada.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_static_fragments.setOnClickListener {
            val intent = Intent(this, StaticFragmentsActivity::class.java)
            startActivity(intent)
        }

        btn_users_list.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }

        btn_notifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        btn_temporizador.setOnClickListener {
            startActivity(Intent(this, TemporizadorActivity::class.java))
        }

        btn_battery_receiver.setOnClickListener {
            startActivity(Intent(this, BroadcastActivity::class.java))
        }

        btn_alarms.setOnClickListener {
            startActivity(Intent(this, AlarmsActivity::class.java))
        }
    }
}
