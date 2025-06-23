package command;

import model.Tarea;
import model.EstadoTarea;

public class ComandoMarcarCompletada implements Comando {
    private Tarea tarea;
    private EstadoTarea estadoAnterior;

    public ComandoMarcarCompletada(Tarea tarea) {
        this.tarea = tarea;
        this.estadoAnterior = tarea.getEstado();
    }

    @Override
    public void ejecutar() {
        tarea.marcarCompletada();
    }

    @Override
    public void deshacer() {
        tarea.setEstado(estadoAnterior);
        System.out.println("Se ha deshecho el cambio, el estado de '" + tarea.getNombre() + "' vuelve a: " + estadoAnterior);
    }
}
