package singleton;

import model.Tarea;
import observer.Observador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendario {
    private static Calendario instancia;
    private List<Tarea> tareas;
    private List<Observador> observadores;

    private Calendario() {
        tareas = new ArrayList<>();
        observadores = new ArrayList<>();
        System.out.println("Calendario iniciado.");
    }

    public static Calendario getInstancia() {
        if (instancia == null) {
            instancia = new Calendario();
        }
        return instancia;
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        
        for (Observador o : observadores) {
            tarea.agregarObservador(o);
        }
        tarea.notificarObservadores();
        System.out.println("Tarea agregada: " + tarea.getNombre());
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void verificarEntregas() {
        LocalDateTime ahora = LocalDateTime.now();
        for (Tarea tarea : tareas) {
            tarea.verificarEntregaAutomatica(ahora);
        }
    }
    public Tarea buscarTareaPorNombre(String nombre) {
    for (Tarea tarea : tareas) {
        if (tarea.getNombre().equalsIgnoreCase(nombre)) {
            return tarea;
        }
    }
    return null;
}

}
