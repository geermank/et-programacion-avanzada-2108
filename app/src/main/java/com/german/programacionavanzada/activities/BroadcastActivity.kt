package com.german.programacionavanzada.activities

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.german.programacionavanzada.R
import com.german.programacionavanzada.broadcasts.BatteryReceiver
import com.german.programacionavanzada.extensions.toast

class BroadcastActivity : BaseActivity() {

    private val batteryReceiver = BatteryReceiver()
    private val intentFilter = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(batteryReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryReceiver)
    }
}