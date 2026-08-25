package cesde.edu.ga.Domain.dto;

public class SubjectDTO {
    private Long id;
    private String nombre;
    private String codigo;
    private Integer creditos;
    private String descripcion;
    private Long profesorId;
    private Long programaId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Long getProfesorId() { return profesorId; }
    public void setProfesorId(Long profesorId) { this.profesorId = profesorId; }
    public Long getProgramaId() { return programaId; }
    public void setProgramaId(Long programaId) { this.programaId = programaId; }
}
