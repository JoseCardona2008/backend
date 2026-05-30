package cesde.edu.ga.exceptions;

public class PersonExceptions extends RuntimeException {

    public PersonExceptions(String mensaje) {
        super(mensaje);
    }

    public  PersonExceptions noEncontrada(Long id) {
        return new PersonExceptions("Persona no encontrada con id: " + id);
    }

    public static PersonExceptions documentoDuplicado(String documentNumber) {
        return new PersonExceptions(
                "Ya existe una persona con el documento: " + documentNumber
        );
    }

    public static PersonExceptions documentoInvalido(String documentType, String documentNumber) {
        return new PersonExceptions(
                "Documento inválido. Tipo: " + documentType + ", Número: " + documentNumber
        );
    }

    public static PersonExceptions inactiva(Long id) {
        return new PersonExceptions("La persona con id " + id + " está inactiva");
    }
}