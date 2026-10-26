package org.example


object Ascensor{
    // estado actual del ascensor
    public var estado_acual: Estados = Estados.Idle
    public var nivel_actual: Int = 0

    fun gestor(botonera: Botonera): Int {
        when (val estado = estado_acual) {
            is Estados.Idle -> {
                return estado.cambiarPiso(botonera, nivel_actual)
            }
            is Estados.MovingUP -> {
                return estado.onEnter()
            }
            is Estados.MovingDOWN -> {
                return estado.onEnter()
            }
            is Estados.Error -> {
                return estado.onEnter()
            }
        }
    }
}