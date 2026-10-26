package org.example

sealed class Estados {
    data class Idle(var nivel_actual: Int) : Estados() {
        fun cambiarPiso(botonera: Botonera): Int {
            println("[Idle] Actualmente en " + nivel_actual)
            if (botonera.boton == 1){
                Ascensor.estado_acual = Estados.MovingUP(nivel_actual)
            }
            else if (botonera.boton == 0){
                Ascensor.estado_acual = Estados.MovingDOWN(nivel_actual)
            }
            else{
                Ascensor.estado_acual = Estados.Error(nivel_actual)
            }
            return nivel_actual;
        }
    }

    data class MovingUP(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int{
            if (nivel_actual == 0){
                println("[MovingUP] Moviéndose a Avenida G. Barbón (nivel 1)")
                nivel_actual = 2;
                Ascensor.estado_acual = Estados.Idle(1)
                return nivel_actual
            }
            else{
                println("[MovingUP] Ya estás en el piso 1")
                nivel_actual = 1;
                Ascensor.estado_acual = Estados.Error(nivel_actual)
                return nivel_actual;
            }
        }
    }
    data class MovingDOWN(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int{
            if (nivel_actual == 1){
                println("Moviéndose a Plaza Compostela (nivel 0)")
                nivel_actual = 2;
                Ascensor.estado_acual = Estados.Idle(0)
                return nivel_actual
            }
            else{
                println("Ya estás en el piso 0")
                nivel_actual = 0;
                Ascensor.estado_acual = Estados.Error(nivel_actual)
                return nivel_actual;
            }
        }
    }
    data class Error(var nivel_actual: Int) : Estados(){
        fun onEnter(): Int{
            println("[Error], se ha cancelado la ejecución de la tarea, volviendo a Idle")
            Ascensor.estado_acual = Estados.Idle(nivel_actual)
            nivel_actual = -1;
            return nivel_actual;
        }
    }
}
