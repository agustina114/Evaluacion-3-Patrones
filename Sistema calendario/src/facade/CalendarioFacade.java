package facade;

import singleton.Calendario;
import model.Tarea;
import model.EstadoTarea;
import observer.AlertaProximidad;
import command.*;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarioFacade {
    private Calendario calendario;
    private GestorComandos gestor;
    private Scanner scanner;

    public CalendarioFacade() {
        calendario = Calendario.getInstancia();
        gestor = new GestorComandos();
        scanner = new Scanner(System.in);
        calendario.agregarObservador(new AlertaProximidad());
    }

    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarTarea();
                case 2 -> mostrarTareas();
                case 3 -> marcarCompletada();
                case 4 -> calendario.verificarEntregas();
                case 5 -> gestor.deshacerUltimo();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Calendario de Evaluaciones ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Verificar entregas automáticas");
        System.out.println("5. Deshacer última acción");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }

    private void agregarTarea() {
        System.out.print("Ingrese nombre de la tarea: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese fecha de entrega (yyyy-MM-dd HH:mm): ");
        String fechaStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fechaEntrega = LocalDateTime.parse(fechaStr, formatter);

        Tarea tarea = new Tarea(nombre, fechaEntrega);
        calendario.agregarTarea(tarea);
    }

    private void mostrarTareas() {
        List<Tarea> tareas = calendario.getTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        tareas.sort((a, b) -> a.getFechaEntrega().compareTo(b.getFechaEntrega()));
        for (Tarea tarea : tareas) {
            tarea.mostrar();
        }
    }

    private void marcarCompletada() {
        System.out.print("Ingrese el nombre exacto de la tarea: ");
        String nombre = scanner.nextLine();
        Tarea tarea = calendario.buscarTareaPorNombre(nombre);
        if (tarea == null) {
            System.out.println("No se encontró la tarea.");
            return;
        }
        Comando comando = new ComandoCambiarEstado(tarea, EstadoTarea.COMPLETADA);
        gestor.ejecutarComando(comando);
    }
}
