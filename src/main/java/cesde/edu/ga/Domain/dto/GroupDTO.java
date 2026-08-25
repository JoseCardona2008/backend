package cesde.edu.ga.dto;

public class GroupDTO {
    private Long id;
    private String nombre;
    private String horario;
    private String salon;
    private Long programaId;
    private Long periodoId;
    private Long profesorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getSalon() { return salon; }
    public void setSalon(String salon) { this.salon = salon; }
    public Long getProgramaId() { return programaId; }
    public void setProgramaId(Long programaId) { this.programaId = programaId; }
    public Long getPeriodoId() { return periodoId; }
    public void setPeriodoId(Long periodoId) { this.periodoId = periodoId; }
    public Long getProfesorId() { return profesorId; }
    public void setProfesorId(Long profesorId) { this.profesorId = profesorId; }
}
