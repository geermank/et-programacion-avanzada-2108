package com.german.programacionavanzada.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.german.programacionavanzada.R
import com.german.programacionavanzada.extensions.remove
import com.german.programacionavanzada.extensions.show
import com.german.programacionavanzada.services.TemporizadorIntentService
import com.german.programacionavanzada.services.TemporizadorPrimerPlano
import com.german.programacionavanzada.services.TemporizadorService
import kotlinx.android.synthetic.main.activity_temporizador.*

class TemporizadorActivity : AppCompatActivity() {

    private val intentFilter = IntentFilter()
    private val temporizadorReceiver = TemporizadorReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporizador)

        intentFilter.addAction(TemporizadorService.START_ACTION)
        intentFilter.addAction(TemporizadorService.FINISH_ACTION)

        btn_start_temporizador.setOnClickListener {
            val intent = Intent(this, TemporizadorService::class.java)
            startService(intent)
        }

        btn_start_temporizador_foreground.setOnClickListener {
            val intent = Intent(this, TemporizadorPrimerPlano::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }
        }

        btn_start_temporizador_intent_service.setOnClickListener {
            startService(Intent(this, TemporizadorIntentService::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this).registerReceiver(temporizadorReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(temporizadorReceiver)
    }

    inner class TemporizadorReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent!!.action == TemporizadorService.START_ACTION) {
                btn_start_temporizador.isEnabled = false
                loading.show()
            } else if (intent.action == TemporizadorService.FINISH_ACTION) {
                btn_start_temporizador.isEnabled = true
                loading.remove()
            }
        }
    }
}
