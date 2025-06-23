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

## 🔧 Patrones de Diseño Aplicados

### 1️⃣ Singleton — Control Centralizado del Calendario

- **Aplicado en:** `Calendario`
- **Motivo:** Asegurar que sólo exista una instancia del calendario.

### 2️⃣ Observer — Alertas Automáticas

- **Aplicado en:** `Observador`, `AlertaProximidad`
- **Motivo:** Notificar al usuario cuando una tarea está próxima a vencerse.

### 3️⃣ Command — Cambio de Estado con Deshacer

- **Aplicado en:** `Comando`, `ComandoCambiarEstado`, `GestorComandos`
- **Motivo:** Encapsular operaciones de cambio de estado y permitir deshacer acciones.

### 4️⃣ Facade — Simplificación de la Interfaz

- **Aplicado en:** `CalendarioFacade`
- **Motivo:** Simplificar el uso del sistema centralizando las operaciones en un único punto de entrada.

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
