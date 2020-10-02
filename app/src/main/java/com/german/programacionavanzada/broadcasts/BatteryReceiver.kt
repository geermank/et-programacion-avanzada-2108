package com.german.programacionavanzada.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.german.programacionavanzada.extensions.toast

class BatteryReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.toast("Te estas quedando sin batería!! :(")
    }
}
