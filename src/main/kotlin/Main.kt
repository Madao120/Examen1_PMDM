package org.example

//ACLARACIÓN: Pongo los println para que se observe que Int devuelve cada estado
fun main() {
    println("---Moviéndose a nivel 1 de forma exitosa\n----------------------------------------------------------------------------")
    // No declaro Idle(0) para comprobar que ya está por default
    // Idle -> MovingUp
    Ascensor.gestor(Botonera.NIVEL_1)
    // MovingUp ejecución
    println(Ascensor.gestor(Botonera.NIVEL_1))
    // COmprobar el estado de donde quedó Idle
    println(Ascensor.gestor(Botonera.NIVEL_1))

    println("\n---Moviéndose a nivel 0 de forma exitosa\n----------------------------------------------------------------------------")
    // Inicio Idle en 1 para que pueda ir a 0 con MovingDOWN
    Ascensor.estado_acual = Estados.Idle(1)
    // Idle -> MovingDOWN
    Ascensor.gestor(Botonera.NIVEL_0)
    // MovingDOWN ejecución
    println(Ascensor.gestor(Botonera.NIVEL_0))
    // Comprobar el estado de Idle después de la ejecución hacia el piso 1
    println(Ascensor.gestor(Botonera.NIVEL_0))

    println("\n---Moviéndose a nivel 1 con ERROR, iniciaré Idle en el piso 1, por lo que no se podrá mover otra vez a piso 1\n----------------------------------------------------------------------------")
    // Inicio Idle en piso 1 para que al querer subir al piso 1, se de cuenta y salte el error para que no haga la operación de moverse
    Ascensor.estado_acual = Estados.Idle(1)
    // Idle -> MOVINGUP
    Ascensor.gestor(Botonera.NIVEL_1)
    // MovingUP -> Error
    println(Ascensor.gestor(Botonera.NIVEL_1))
    // Error
    println(Ascensor.gestor(Botonera.NIVEL_1))
    // COmprobamos que haya vuelto a Idle con el piso que tenía antes del error (ya que el ascensor no se movió y se quedó en el sitio)
    println(Ascensor.gestor(Botonera.NIVEL_1))

    println("\n---Moviéndose a nivel 0 de forma erronea, como antes, iniciándolo en el nivel que da error\n----------------------------------------------------------------------------")
    // Inicio Idle en piso 1 para que al querer subir al piso 1, se de cuenta y salte el error para que no haga la operación de moverse
    Ascensor.estado_acual = Estados.Idle(0)
    // Idle -> MOVINGDOWN
    Ascensor.gestor(Botonera.NIVEL_0)
    // MovingDOWN -> Error
    println(Ascensor.gestor(Botonera.NIVEL_0))
    // Error
    println(Ascensor.gestor(Botonera.NIVEL_0))
    // COmprobamos que haya vuelto a Idle con el piso que tenía antes del error (ya que el ascensor no se movió y se quedó en el sitio)
    println(Ascensor.gestor(Botonera.NIVEL_0))


}