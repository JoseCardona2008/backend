package cesde.edu.ga.exceptions;

public class PeriodExceptions extends RuntimeException {

    public PeriodExceptions(String mensaje) {
        super(mensaje);
    }

    public static PeriodExceptions noEncontrado(Long id) {
        return new PeriodExceptions("Período no encontrado con id: " + id);
    }

    public static PeriodExceptions codigoDuplicado(String code) {
        return new PeriodExceptions("Ya existe un período con el código: " + code);
    }

    public static PeriodExceptions fechasInvalidas(String startDate, String endDate) {
        return new PeriodExceptions(
                "Fechas inválidas. Inicio: " + startDate + " - Fin: " + endDate
        );
    }
}