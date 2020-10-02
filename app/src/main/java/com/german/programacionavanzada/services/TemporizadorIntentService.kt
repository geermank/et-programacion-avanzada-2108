package com.german.programacionavanzada.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class TemporizadorIntentService : IntentService("TemporizadorIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        // toda la logica de nuestro trabajo
        Log.i("TemporizadorIS", "Esta por empezar la tarea")
        // aca corre en el worker thread
        Thread.sleep(5000)
        Log.i("TemporizadorIS", "Terminó la tarea")
    }
}
