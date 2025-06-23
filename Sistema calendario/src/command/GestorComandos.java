package command;

import java.util.Stack;

public class GestorComandos {
    private Stack<Comando> historial;

    public GestorComandos() {
        historial = new Stack<>();
    }

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            Comando ultimo = historial.pop();
            ultimo.deshacer();
            System.out.println("Se ha deshecho la última acción.");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }
}
