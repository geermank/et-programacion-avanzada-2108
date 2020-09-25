package com.german.programacionavanzada.extensions

import android.view.View
import com.german.programacionavanzada.models.User

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.remove() {
    visibility = View.GONE
}

fun List<User>.hayUsuarios(): Int {
    return size
}
