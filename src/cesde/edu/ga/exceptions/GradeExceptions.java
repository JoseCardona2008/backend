package cesde.edu.ga.exceptions;

public class GradeExceptions extends RuntimeException {

    public GradeExceptions(String mensaje) {
        super(mensaje);
    }

    public static GradeExceptions noEncontrada(Long id) {
        return new GradeExceptions("Calificación no encontrada con id: " + id);
    }

    public static GradeExceptions duplicada(Long enrollmentId, Long groupSubjectId) {
        return new GradeExceptions(
                "Ya existe una calificación para la matrícula " + enrollmentId +
                        " y la materia del grupo " + groupSubjectId
        );
    }

    public static GradeExceptions notaInvalida(Double nota) {
        return new GradeExceptions(
                "La nota final no es válida: " + nota + ". Debe estar entre 0 y 5"
        );
    }
}