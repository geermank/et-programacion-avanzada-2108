package com.german.programacionavanzada.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class TemporizadorService : Service() {

    companion object {
        const val START_ACTION = "START_ACTION"
        const val FINISH_ACTION = "FINISH_ACTION"
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
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
            broadcastTemporizadorMessage(START_ACTION)
            Log.i("TemporizadorService", "Esta por empezar la tarea $id")
            // aca corre en el worker thread
            Thread.sleep(5000)
            Log.i("TemporizadorService", "Terminó la tarea $id")
            stopSelf(id)
            broadcastTemporizadorMessage(FINISH_ACTION)
        }).start()
    }

    private fun broadcastTemporizadorMessage(action: String) {
        val intent = Intent(action)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}

/*
 *  startService -> crea el sevicio -> le asigna id (1)
 *  startService ->                 -> le asigna id (2)
 *  startService ->                 -> le asigna id (3)
 *
 *  la corrida (1) termina -> tengo que detener el servicio -> detener (1)
 *  la corrida (1) termina -> tengo que detener el servicio -> detener (2)
 *  la corrida (1) termina -> tengo que detener el servicio -> detener (3)
 *
 *  se destruye el servicio
 *
 */