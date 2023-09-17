# Piano

|               |                                              |
|-------------- |----------------------------------------------|
|**Autor**      | Unai Pueyo Almodóvar ~ Brouse13              |
|**Versión**    | 1.0                                          |
|**Descripción**| Repositorio de la práctica de Programación II|

### Objetivo
El objetivo de esta práctica era demostrar los conocimientos de la creación de interfaces gráficas usando los componentes de **java.awt.*** además del uso otros componentes como la reproducción de sonidos
 
### Funcionamiento
El juego consta de una interfaz principal dónde se puede seleccionar las siguientes opciones:
 - Creación de una melodía
 - Reproducir la última melodía
  - Adivinar la última melodía
 - Cerrar juego


### Creación de una melodía
Esta pantalla te permite crear una nueva melodía haciendo click a los diferentes icono de la parte inferior. La canción se acabará de grabar una vez apretada la tecla _FIN_ o llegando al límite de 110 notas. Una vez acabada se guardará en memoria y se permitirá acceder al resto de menús.

### Reproducir la última melodía 
Esta pantalla te permitirá poder reproducir la última melodía creada nota por nota (En el caso de que exista).

### Adivinar la última melodía
Esta pantalla te permitirá poder adivinar cada una de las notas musicales que se han hecho clic durante la creación de la melodía. Este modo funciona en base a la prueba y error ya que es tal y como se pedía en las especificaciones de la asignatura

### Cerrar juego
Esta función sirve para poder cerrar el juego


### Información de interés
Para poder llevar a cabo esta práctica de usaron dos patrones de diseño::
- **MVC** (Modelo Vista Controlador): Este patrón te permite separar la lógica de los menús en partes más pequeñas y fáciles de mantener que comparten una estructura en común. Además te permite poder cambiar en cualquier momento cualquiera de las tres partes sin tener que modificar las otras.
- **Singleton**: Usado para poder limitar de la cantidad de instancias de un objeto que están creadas en 1 y así hacer lo más genérico la creación de las interfaces.