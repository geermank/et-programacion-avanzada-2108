package com.german.programacionavanzada.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.german.programacionavanzada.R
import com.german.programacionavanzada.services.TemporizadorPrimerPlano
import com.german.programacionavanzada.services.TemporizadorService
import kotlinx.android.synthetic.main.activity_temporizador.*

class TemporizadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporizador)

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
    }
}