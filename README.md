# Evaluacion-3-Patrones de diseño

##**Calendario de Evaluaciones**

##**Problematica planteada**
- El proyecto surge de una problematica personal relacionada con la desorganizacion de tareas, evaluacione y trabajos académicos.
  
- En la vida cotidiana es común olvidar fechas importantes o perder el orden de que tareas deben realizarse con mayor urgencia. La falta de planificacion genera estres y baja productividad.

Este sistema busca solucionar el problema de priorizacion mediante:
  - Registro de tareas con fechas de entrega.
  - Alertas automaticas cuando se aproxima el plazo.
  - Control del estado de cada tarea (pendiente, completada, entregada).
  - Posibilidad de deshacer acciones.
  - Visualización organizada de las actividades.
    
##**🎯 Objetivo del sistema**
   Diseñar un calendario de evaluaciones que:
  - Permita al usuario agregar tareas con fecha de entrega.
  - Genere alertas cuando se aproxima el vencimiento.
  - Mantenga un control del estado de cada tarea.
  - Permita deshacer cambios de estado.
  - Sea modular, escalable y mantenible utilizando los patrones de diseño.

##**🔧 Patrones de Diseño**

1️⃣ Singleton -- *Control Centralizado del calendario*
    - Dónde se aplicó: Clase **Calendario**
    - Por qué: Se necesita que exista un unico calendario central para todas las tareas, evitando multiples instancias desincronizadas. El patrón **Singleton** garantiza que siempre que se accede a la misma instancia.
    - Beneficio: 
        * Centralizacion.
        * Consistencia de los datos.
        * Evita problemas de sincronizacion.

        
2️⃣ Observer — *Alertas automáticas de proximidad de vencimiento*
    - Dónde se aplicó: Interfaces **Observador**, clase **AlertaProximidad**.
    - Por qué: Queremos notificar al usuario cuando alguna tarea esta proxima a vencer. Cada vez que se agrega una nueva tarea, los observadores son notificados y pueden evaluar si deben emitir alertas. 
    - Beneficio: 
        * Desacoplamiento: el calendario no sabe que hacer con las alertas.
        * Facil de extender con nuevos tipos de notificaciones.
        * Permite futuras ampliaciones.


3️⃣ Command — *Cambio de estado con deshacer*   
    - Dónde se aplicó: Interfaces **Comando**, clases **ComandoCambiarEstado**, **GestorComandos**.
    - Por qué: Permite encapsular cada operación de cambio de estado (por ejemplo, marcar como completada) y guardar un historial papra poder deshacer la ultima accion si el usuario se equivoca.
    - Beneficio: 
        * Deshacer (Undo) simple y eficiente.
        * Encapsula las operaciones de forma independiente.
        * Facilita la extensión a nuevos comandos en el futuro.


4️⃣ Facade — *Simplificación de la interfaz de uso* (Extra)
    - Dónde se aplicó: Clase **CalendarioFacade**
    - Por qué: El menú de consola funciona como cliente del sistema y para evitar tener que coordinar multiples clases directamente se crea una fachada que centraliza las operaciones mas comunes de forma simple.
    - Beneficio: 
        * Simplifica el accceso para el usuario final.
        * Reduce el acoplamiento.
        * Permite agregar o modificar la logica interna sin afectar el cliente.

```Estructura del proyecto
    /Sistema Calendario
      /src
        -/command
            -Comando.java
            -ComandoCambiarEstado.java
            -ComandoMarcarCompletada.java
            -GestorComandos.java
        -/facade
            -CalendarioFacade.java
        -/model
            -EstadoTarea.java
            -Tarea.java
        -/observer
            -AlertaProximidad.java
            -Observador.java
        -/singleton
            -Calendario.java
        -Main.java
```
##**🔬 Conclusión personal**

- Este proyecto permite al usuario mantener una planificacion clara de sus tareas, ofreciendo:
✅ Registro de actividades
✅ Priorización automática
✅ Alertas tempranas de vencimiento
✅ Control del estado de las tareas
✅ Deshacer acciones recientes

