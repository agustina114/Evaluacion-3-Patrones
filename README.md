# 📅 Sistema de Calendario de Evaluaciones

Proyecto realizado aplicando **Patrones de Diseño** en Java.

---

## 💡 Problemática planteada

Este proyecto surge de una problemática personal relacionada con la desorganización de tareas, evaluaciones y trabajos académicos.

En la vida cotidiana es común olvidar fechas importantes o perder el orden de las tareas más urgentes, lo que genera estrés y baja productividad.

El sistema busca solucionar el problema de priorización mediante:

- Registro de tareas con fechas de entrega.
- Alertas automáticas cuando se aproxima el vencimiento.
- Control del estado de cada tarea (pendiente, completada, entregada).
- Posibilidad de deshacer acciones.
- Visualización organizada de las actividades.

---

## 🎯 Objetivo del sistema

Diseñar un calendario de evaluaciones que:

- Permita agregar tareas con fecha de entrega.
- Genere alertas al aproximarse la fecha de vencimiento.
- Controle el estado de cada tarea.
- Permita deshacer cambios recientes.
- Sea modular, escalable y mantenible mediante patrones de diseño.

---

---

### 1️⃣ Singleton — *Control Centralizado del Calendario*

- **Dónde se aplicó:** Clase `Calendario`
- **Por qué:**  
  Se requiere un único calendario centralizado para gestionar todas las tareas y evitar múltiples instancias desincronizadas.  
  El patrón Singleton asegura que siempre se accede a la misma instancia.

- **Beneficios:**
  - Centralización de la gestión.
  - Consistencia de los datos.
  - Evita problemas de sincronización.

---

### 2️⃣ Observer — *Alertas automáticas de proximidad de vencimiento*

- **Dónde se aplicó:** Interfaces `Observador`, clase `AlertaProximidad`
- **Por qué:**  
  Permite notificar al usuario cuando alguna tarea está próxima a vencer. Cada vez que se agrega una nueva tarea, los observadores son notificados y evalúan si deben emitir alertas.

- **Beneficios:**
  - Desacoplamiento entre el calendario y el sistema de alertas.
  - Facilita la extensión a nuevos tipos de notificaciones.
  - Permite futuras ampliaciones (email, SMS, etc.).

---

### 3️⃣ Command — *Cambio de estado con deshacer*

- **Dónde se aplicó:** Interfaces `Comando`, clases `ComandoCambiarEstado`, `GestorComandos`
- **Por qué:**  
  Permite encapsular las operaciones de cambio de estado (por ejemplo, marcar una tarea como completada) y almacenar un historial para deshacer acciones si el usuario comete un error.

- **Beneficios:**
  - Implementación simple del deshacer (Undo).
  - Encapsulación de operaciones de forma independiente.
  - Facilita la extensión con nuevos comandos.

---

### 4️⃣ Facade — *Simplificación de la interfaz de uso*

- **Dónde se aplicó:** Clase `CalendarioFacade`
- **Por qué:**  
  El menú de consola actúa como cliente del sistema. La fachada centraliza y simplifica el acceso a las operaciones más comunes evitando que el usuario interactúe directamente con las múltiples clases internas.

- **Beneficios:**
  - Simplificación de la lógica de interacción.
  - Reducción del acoplamiento.
  - Facilidad para ampliar o modificar la lógica sin afectar al cliente.

---
## 📁 Estructura del Proyecto
```

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
---

## 🔬 Conclusión

Este sistema permite:

- ✅ Registrar tareas.
- ✅ Priorizar tareas según vencimiento.
- ✅ Alertar al usuario cuando las tareas están próximas.
- ✅ Controlar el estado de cada actividad.
- ✅ Deshacer acciones recientes.

---
