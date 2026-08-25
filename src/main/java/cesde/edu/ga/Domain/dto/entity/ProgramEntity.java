package cesde.edu.ga.Domain.dto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "coordinador_id")
    private TeacherEntity coordinador;
}
