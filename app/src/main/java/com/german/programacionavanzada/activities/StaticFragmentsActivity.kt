package com.german.programacionavanzada.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.german.programacionavanzada.R

class StaticFragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_fragments)
    }

    fun show(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
