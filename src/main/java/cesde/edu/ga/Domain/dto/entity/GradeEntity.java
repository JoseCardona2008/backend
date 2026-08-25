package cesde.edu.ga.Domain.dto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id", nullable = false)
    private EnrollmentEntity inscripcion;
}
