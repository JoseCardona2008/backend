package cesde.edu.ga.exceptions;

public class EnrollmentExceptions extends RuntimeException {

    public EnrollmentExceptions (String mensaje) {
        super(mensaje);
    }

    public static EnrollmentExceptions  noEncontrada(Long id) {
        return new EnrollmentExceptions ("Matrícula no encontrada con id: " + id);
    }

    public static EnrollmentExceptions  duplicada(Long estudianteId, Long grupoId) {
        return new EnrollmentExceptions (
                "El estudiante " + estudianteId + " ya está matriculado en el grupo " + grupoId
        );
    }

    public static EnrollmentExceptions  periodoCerrado() {
        return new EnrollmentExceptions ("El período de matrícula está cerrado");
    }
}