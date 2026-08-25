package cesde.edu.ga.exceptions;

public class ProgramExceptions extends RuntimeException {

    public ProgramExceptions(String mensaje) {
        super(mensaje);
    }

    public static ProgramExceptions noEncontrado(Long id) {
        return new ProgramExceptions("Programa no encontrado con id: " + id);
    }

    public static ProgramExceptions codigoDuplicado(String code) {
        return new ProgramExceptions(
                "Ya existe un programa con el código: " + code
        );
    }

    public static ProgramExceptions nombreDuplicado(String name) {
        return new ProgramExceptions(
                "Ya existe un programa con el nombre: " + name
        );
    }
}