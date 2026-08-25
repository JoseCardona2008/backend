package cesde.edu.ga.exceptions;

public class SubjectExceptions extends RuntimeException {

    public SubjectExceptions(String mensaje) {
        super(mensaje);
    }

    public static SubjectExceptions noEncontrada(Long id) {
        return new SubjectExceptions("Asignatura no encontrada con id: " + id);
    }

    public static SubjectExceptions codigoDuplicado(String code) {
        return new SubjectExceptions("Ya existe una asignatura con el código: " + code);
    }
}
