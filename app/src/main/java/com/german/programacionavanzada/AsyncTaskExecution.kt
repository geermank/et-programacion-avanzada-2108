package com.german.programacionavanzada

import android.os.AsyncTask
import com.german.programacionavanzada.activities.AsyncTaskActivity

class AsyncTaskExecution(private val activity: AsyncTaskActivity) : AsyncTask<String, Unit, Int>() {

    // corre en el main thread
    override fun onPreExecute() {
        super.onPreExecute()

    }

    // corre en el worker thread
    override fun doInBackground(vararg params: String?): Int {
        // ejecutamos la tarea de fondo
        // aca
        activity.toast()
        return 0
    }

    // corre en el main thread
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)

    }
}
