package cesde.edu.ga.dto;

public class TeacherDTO {
    private Long id;
    private String fechaContratacion;
    private String especialidad;
    private Long usuarioId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
