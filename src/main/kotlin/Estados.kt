package org.example

import org.example.Ascensor.nivel_actual


sealed class Estados {
        object Idle : Estados() {
            fun cambiarPiso(botonera: Botonera, nivel_actual: Int): Int {
                println("Actualmente en " + nivel_actual)
                if (botonera.boton == 0){
                    Ascensor.estado_acual = Estados.MovingUP(nivel_actual)
                }
                else if (botonera.boton == 1){
                    Ascensor.estado_acual = Estados.MovingDOWN(nivel_actual)
                }
                else{
                    Ascensor.estado_acual = Estados.Error
                }
                return nivel_actual;
            }
        }

        data class MovingUP(var nivel_actual: Int) : Estados(){
            fun onEnter(): Int{
                if (nivel_actual == 0){
                    println("Moviéndose a Plaza Compostela")
                    nivel_actual = 2;
                    Ascensor.estado_acual = Estados.Idle
                    return nivel_actual
                }
                else{
                    println("Ya estás en el piso 1")
                    nivel_actual = 1;
                    Ascensor.estado_acual = Estados.Error
                    return nivel_actual;
                }
            }
        }
        data class MovingDOWN(var nivel_actual: Int) : Estados(){
            fun onEnter(): Int{
                if (nivel_actual == 1){
                    println("Moviéndose a Plaza Compostela")
                    nivel_actual = 2;
                    Ascensor.estado_acual = Estados.Idle
                    return nivel_actual
                }
                else{
                    println("Ya estás en el piso 1")
                    nivel_actual = 1;
                    Ascensor.estado_acual = Estados.Error
                    return nivel_actual;
                }
            }
        }
        object Error : Estados(){
            fun onEnter(): Int{
                Ascensor.estado_acual = Estados.Idle
                nivel_actual = -1;
                return nivel_actual;
            }
        }
    }
