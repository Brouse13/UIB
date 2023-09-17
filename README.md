# Puzzle

|               |                                                                  |
|-------------- |------------------------------------------------------------------|
|**Autor**      | Unai Pueyo Almodóvar ~ Brouse13                                  |
|**Versión**    | 1.0                                                              |
|**Descripción**| Repositorio es la practica final de la asignatura Programación II|

### Objetivo
El objetivo de esta práctica era demostrar los conocimientos de la creación de interfaces gráficas usando los componentes de **java.awt.*** explicados durante toda la asignatura. Además de también poder practicar la abstracción de datos (POO).
 
### Funcionamiento
El juego consta de una interfaz principal dónde se puede seleccionar mediante 3 menús distintos las siguientes opciones:
 - Creación de una partida
 - Ver estadísticas globales
 - Ver estadísticas por jugador
 - Modificar el directorio de imágenes*
 - Cerrar juego
<small>*La modificación del directorio es la única opción que solo es accesible mediante el menú superior<small>

### Creación de la partida
Mediante un menú flotante se le dará la opción al usuario de poder crear una nueva partida, para ello, tundra que introducir el número de filas y columnas (mismo número) y el nombre de usuario. Una vez creada, un contador empezará y tendrás un tiempo de `rows * cols * 4` para poder resolver el puzzle. 
Cuando el tiempo se acabe o se resuelva el puzzle saltará un mensaje informando de como ha acabado la partida y de cuantos puntos se han conseguido (En el caso de ganar la partida los puntos se calculan como `rows * cols`) y se guardan las estadísticas en un archivo para poder ser consultadas.

### Ver estadísticas globales 
Una vez dentro de esta sección, se mostrarán cada una de las partidas jugadas por orden de cronológico, en el caso de no haber ninguna partida de mostrará el mensaje de `No hay datos para mostrar`.

### Ver estadísticas por jugador
Esta sección funciona igual que la de estadísticas globales, la única diferencia es que antes de mostrarlas se le pregunta al usuario por un nombre de usuario a filtrar para así elegir solo las estadística de un jugador en concreto.

### Salir
Esta función sirve para poder cerrar el juego


### Información de interés
Para poder llevar a cabo esta práctica de usaron dos patrones de diseño::
- **MVC** (Modelo Vista Controlador): Este patrón te permite separar la lógica de los menús en partes más pequeñas y fáciles de mantener que comparten una estructura en común. Además te permite poder cambiar en cualquier momento cualquiera de las tres partes sin tener que modificar las otras.
- **Singleton**: Usado para poder limitar de la cantidad de instancias de un objeto que están creadas en 1 y así hacer lo más genérico la creación de las interfaces.