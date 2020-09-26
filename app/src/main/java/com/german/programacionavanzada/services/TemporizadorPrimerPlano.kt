package com.german.programacionavanzada.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.german.programacionavanzada.NotificationUtils

class TemporizadorPrimerPlano : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        val notification = NotificationUtils.createNotification(this, "servicios",
            "Temporizador en curso", "Aguarde por favor")
        startForeground(1, notification)
        Log.i("TemporizadorService", "El servicio se está creando")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // aca vamos a meter la tarea que quiero que mi servicio ejecute!
        startTemporizador(startId)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TemporizadorService", "El servicio se está destruyendo")
    }

    private fun startTemporizador(id: Int) {
        Thread(Runnable {
            Log.i("TemporizadorService", "Esta por empezar la tarea $id")
            // aca corre en el worker thread
            Thread.sleep(5000)
            Log.i("TemporizadorService", "Terminó la tarea $id")
            stopSelf(id)
        }).start()
    }
}