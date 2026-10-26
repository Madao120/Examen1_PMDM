package org.example

import org.example.Ascensor.nivel_actual
import org.example.Ascensor.estado_acual
import org.example.Ascensor.gestor
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {
    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle
        nivel_actual = 0
    }

    @Test
    fun `gestor reinicia el nivel cuando el estado es Idle`() {
        estado_acual = Estados.Idle
        nivel_actual = 5

        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingUP`() {
        estado_acual = Estados.MovingUP
        nivel_actual = 5

        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingDOWN`() {
        estado_acual = Estados.MovingDOWN
        nivel_actual = 5

        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel de error cuando el estado es Error`() {
        estado_acual = Estados.Error
        nivel_actual = 5

        assertEquals(-1, gestor())
        assertEquals(-1, nivel_actual)
    }
}