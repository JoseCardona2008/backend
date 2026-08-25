package cesde.edu.ga.dto;

public class ProgramDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer duracion;
    private Long coordinadorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    public Long getCoordinadorId() { return coordinadorId; }
    public void setCoordinadorId(Long coordinadorId) { this.coordinadorId = coordinadorId; }
}
