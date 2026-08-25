package cesde.edu.ga.Domain.dto;

public class GradeDTO {
    private Long id;
    private Double valor;
    private String observacion;
    private Long inscripcionId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
    public Long getInscripcionId() { return inscripcionId; }
    public void setInscripcionId(Long inscripcionId) { this.inscripcionId = inscripcionId; }
}
