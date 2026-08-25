package cesde.edu.ga.dto;

public class StudentDTO {
    private Long id;
    private String codigo;
    private String fechaInscripcion;
    private Long usuarioId;
    private Long programaId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getProgramaId() { return programaId; }
    public void setProgramaId(Long programaId) { this.programaId = programaId; }
}
