package observer;

import model.Tarea;
import java.time.LocalDateTime;
import java.time.Duration;

public class AlertaProximidad implements Observador {
    @Override
    public void actualizar(Tarea tarea) {
        LocalDateTime ahora = LocalDateTime.now();
        Duration diferencia = Duration.between(ahora, tarea.getFechaEntrega());

        if (diferencia.toHours() <= 24 && diferencia.toHours() > 0) {
            System.out.println("⚠ ATENCIÓN: La tarea '" + tarea.getNombre() + "' vence en menos de 24 horas.");
        }
    }
}
