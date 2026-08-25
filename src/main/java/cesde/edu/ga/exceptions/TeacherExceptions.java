package cesde.edu.ga.exceptions;

public class TeacherExceptions extends RuntimeException {

    public TeacherExceptions(String mensaje) {
        super(mensaje);
    }

    public static TeacherExceptions noEncontrado(Long id) {
        return new TeacherExceptions("Docente no encontrado con id: " + id);
    }

    public static TeacherExceptions inactivo(Long id) {
        return new TeacherExceptions("El docente con id " + id + " está inactivo");
    }
}