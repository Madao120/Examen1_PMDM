package org.example

import org.example.Ascensor.estado_acual
import org.example.Ascensor.gestor
import org.example.Ascensor.nivel_actual
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle
        nivel_actual = 0
    }

    @Test
    fun `gestor reinicia el nivel cuando el estado es Idle`() {
        estado_acual = Estados.Idle
        nivel_actual = 5

        assertEquals(0, gestor(Botonera.NIVEL_0))
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingUP`() {
        estado_acual = Estados.MovingUP(5)
        nivel_actual = 5

        assertEquals(2, gestor(Botonera.NIVEL_0))
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingDOWN`() {
        estado_acual = Estados.MovingDOWN(5)
        nivel_actual = 5

        assertEquals(2, gestor(Botonera.NIVEL_0))
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel de error cuando el estado es Error`() {
        estado_acual = Estados.Error
        nivel_actual = 5

        assertEquals(-1, gestor(Botonera.NIVEL_0))
        assertEquals(-1, nivel_actual)
    }
}