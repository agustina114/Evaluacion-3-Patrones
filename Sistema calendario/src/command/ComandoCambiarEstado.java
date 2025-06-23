package command;

import model.Tarea;
import model.EstadoTarea;

public class ComandoCambiarEstado implements Comando {
    private Tarea tarea;
    private EstadoTarea nuevoEstado;
    private EstadoTarea estadoAnterior;

    public ComandoCambiarEstado(Tarea tarea, EstadoTarea nuevoEstado) {
        this.tarea = tarea;
        this.nuevoEstado = nuevoEstado;
    }

    @Override
    public void ejecutar() {
        estadoAnterior = tarea.getEstado();
        tarea.cambiarEstado(nuevoEstado);
    }

    @Override
    public void deshacer() {
        tarea.cambiarEstado(estadoAnterior);
    }
}
