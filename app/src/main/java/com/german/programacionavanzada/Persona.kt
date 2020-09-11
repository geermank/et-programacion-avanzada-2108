package com.german.programacionavanzada

/**
 * final class Persona {
 *
 * }
 *
 * class Empleado extends Persona { }
 */
interface HacerEjercicio {
    fun irAlGimnasio()
    fun jugarALaPelota(): String
}

// open
abstract class SerHumano {
    abstract fun comer()
}

open class Persona(var name: String = "German", var edad: Int) : SerHumano() { // constructor primario Any (el object de java)

    var esMayorDeEdad = false

    init {
        // aca
        if (edad > 18) {
            esMayorDeEdad = true
        }
    }

    var surname: String = ""

    constructor(name: String, surname: String): this(name, 0) {
        this.surname = surname
    }

    override fun comer() {

    }

    open fun saludar(): String {
        return "Hola, te saluda $name"
    }
}


// implements
class Empleado : HacerEjercicio {

    override fun irAlGimnasio() {

    }

    override fun jugarALaPelota(): String {
        return ""
    }
}
