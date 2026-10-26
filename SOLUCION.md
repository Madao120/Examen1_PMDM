## SOLUCIÓN

### Estados



### Transiciones
Idle puede ir tanto a MovingUP si botonera es Nivel_1, como a MovingDOWN si botonera es Nivel_1, como a error si no cae en ninguno de los anteriores

### MovingUp
Dará error en caso de que el piso actual sea el mismo que se ha escogido
En caso de que el nivel introducido sea correcto parasá 

### Enum
Realicé un enum con 2 variables para que funcionara como la botonera del halo, caad botón devuelve un int que será el nivel al que se querrá ir