package cesde.edu.ga.exceptions;

public class UserRoleExceptions extends RuntimeException {

    public UserRoleExceptions(String mensaje) {
        super(mensaje);
    }

    public static UserRoleExceptions noEncontrado(Long id) {
        return new UserRoleExceptions("UserRole no encontrado con id: " + id);
    }
}
