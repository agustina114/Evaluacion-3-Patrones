package model;

import observer.Observador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private String nombre;
    private LocalDateTime fechaEntrega;
    private EstadoTarea estado;
    private List<Observador> observadores;

    public Tarea(String nombre, LocalDateTime fechaEntrega) {
        this.nombre = nombre;
        this.fechaEntrega = fechaEntrega;
        this.estado = EstadoTarea.PENDIENTE;
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void marcarCompletada() {
        if (estado == EstadoTarea.PENDIENTE) {
            estado = EstadoTarea.COMPLETADA;
            System.out.println("Tarea '" + nombre + "' marcada como COMPLETADA.");
        }
    }

    public void verificarEntregaAutomatica(LocalDateTime ahora) {
        if (estado == EstadoTarea.PENDIENTE && ahora.isAfter(fechaEntrega)) {
            estado = EstadoTarea.ENTREGADA;
            System.out.println("Tarea '" + nombre + "' ha sido marcada como ENTREGADA automáticamente.");
        }
    }

    public void mostrar() {
        System.out.println("- " + nombre + " | Fecha entrega: " + fechaEntrega + " | Estado: " + estado);
    }

    public void setEstado(EstadoTarea nuevoEstado) {
        this.estado = nuevoEstado;
    }
    public void cambiarEstado(EstadoTarea nuevoEstado) {
    this.estado = nuevoEstado;
    System.out.println("Tarea '" + nombre + "' ahora está: " + estado);
}


}
