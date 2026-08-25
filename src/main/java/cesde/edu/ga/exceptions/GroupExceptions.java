package cesde.edu.ga.exceptions;

public class GroupExceptions extends RuntimeException {

    public GroupExceptions(String mensaje) {
        super(mensaje);
    }

    public static GroupExceptions noEncontrado(Long id) {
        return new GroupExceptions("Grupo no encontrado con id: " + id);
    }

    public static GroupExceptions codigoDuplicado(String code) {
        return new GroupExceptions("Ya existe un grupo con el código: " + code);
    }

    public static GroupExceptions horarioInvalido(String schedule) {
        return new GroupExceptions("Horario inválido o conflictivo: " + schedule);
    }
}