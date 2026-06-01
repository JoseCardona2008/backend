package cesde.edu.ga.exceptions;

public class UserExceptions extends RuntimeException {

    public UserExceptions(String mensaje) {
        super(mensaje);
    }

    public static UserExceptions noEncontrado(Long id) {
        return new UserExceptions("Usuario no encontrado con id: " + id);
    }

    public static UserExceptions usernameDuplicado(String username) {
        return new UserExceptions("Ya existe un usuario con el nombre de usuario: " + username);
    }

    public static UserExceptions contrasenaInvalida() {
        return new UserExceptions("La contraseña no es válida");
    }
}
