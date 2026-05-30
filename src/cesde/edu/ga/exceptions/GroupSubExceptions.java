package cesde.edu.ga.exceptions;

public class GroupSubExceptions extends RuntimeException {

    public GroupSubExceptions(String mensaje) {
        super(mensaje);
    }

    public static GroupSubExceptions noEncontrado(Long id) {
        return new GroupSubExceptions("Asignación de grupo-materia no encontrada con id: " + id);
    }

    public static GroupSubExceptions duplicado(Long groupId, Long subjectId) {
        return new GroupSubExceptions(
                "La materia " + subjectId + " ya está asignada al grupo " + groupId
        );
    }

    public static GroupSubExceptions sinDocenteAsignado(Long groupSubjectId) {
        return new GroupSubExceptions(
                "La asignación " + groupSubjectId + " no tiene docente asignado"
        );
    }
}