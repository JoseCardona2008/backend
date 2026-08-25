package cesde.edu.ga.Domain.dto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private StudentEntity estudiante;

    @ManyToOne
    @JoinColumn(name = "grupo_asignatura_id", nullable = false)
    private GroupSubjectEntity grupoAsignatura;
}
