package com.german.programacionavanzada.activities

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.german.programacionavanzada.AsyncTaskExecution
import com.german.programacionavanzada.R

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        val task = AsyncTaskExecution(this)
        task.execute("German")
    }

    fun toast() {
        // toast
    }
}
