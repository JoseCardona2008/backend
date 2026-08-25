package cesde.edu.ga.Domain.dto;

public class EnrollmentDTO {
    private Long id;
    private String fechaInscripcion;
    private Long estudianteId;
    private Long grupoAsignaturaId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public Long getEstudianteId() { return estudianteId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public Long getGrupoAsignaturaId() { return grupoAsignaturaId; }
    public void setGrupoAsignaturaId(Long grupoAsignaturaId) { this.grupoAsignaturaId = grupoAsignaturaId; }
}
