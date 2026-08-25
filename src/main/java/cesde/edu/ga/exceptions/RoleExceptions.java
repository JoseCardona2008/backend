package cesde.edu.ga.exceptions;

public class RoleExceptions extends RuntimeException {

    public RoleExceptions(String mensaje) {
        super(mensaje);
    }

    public static RoleExceptions noEncontrado(Long id) {
        return new RoleExceptions("Rol no encontrado con id: " + id);
    }
}
