package cesde.edu.ga.exceptions;

public class StudentExceptions extends RuntimeException {

    public StudentExceptions(String mensaje) {
        super(mensaje);
    }

    public static StudentExceptions noEncontrado(Long id) {
        return new StudentExceptions("Estudiante no encontrado con id: " + id);
    }

    public static StudentExceptions inactivo(Long id) {
        return new StudentExceptions("El estudiante con id " + id + " está inactivo");
    }

    public static StudentExceptions fechaNacimientoInvalida(String birthDate) {
        return new StudentExceptions(
                "Fecha de nacimiento inválida: " + birthDate
        );
    }
}