package org.example

import org.example.Ascensor.estado_acual
import org.example.Ascensor.gestor
import org.example.Ascensor.nivel_actual
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class  GestorTest {
    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle(0)
        nivel_actual = 0
    }

    @Test
    fun nivelIdle() {
        // Idle -> MovingUP
        val prueba = gestor(Botonera.NIVEL_1)

        assertEquals(0, prueba)
        // Pongo MovingUp ya que quiero comprobar que haya pasado sin cambiar el nivel
        assertEquals(Estados.MovingUP(0), estado_acual)
    }
    @Test
    fun testMovingUP() {
        estado_acual = Estados.Idle(0)

        // Idle -> MovingUP
        gestor(Botonera.NIVEL_1)

        // MovingUP -> Idle
        val resultado = gestor(Botonera.NIVEL_1)

        println(resultado)

        // Terminamos el ciclo en Idle para comprobar que haya cambiado de piso
        assertEquals(2, resultado)
        assertEquals(Estados.Idle(1), estado_acual)
    }
    @Test
    fun testMovingDown() {
        estado_acual = Estados.Idle(1)

        // Idle -> MovingDOWN
        gestor(Botonera.NIVEL_0)

        // MovingDOWN -> Idle
        val resultado = gestor(Botonera.NIVEL_0)

        println(resultado)

        assertEquals(2, resultado)
        assertEquals(Estados.Idle(0), estado_acual)
    }
    @Test
    fun tstError() {
        @Test
        fun tstError() {
            estado_acual = Estados.Idle(1)

            // Idle -> MovingUP
            gestor(Botonera.NIVEL_1)

            // MovingUP -> Error
            println(gestor(Botonera.NIVEL_1))

            // Error -> Idle
            println(gestor(Botonera.NIVEL_1))

            assertEquals(Estados.Idle(-1), estado_acual)
        }    }
}