package cesde.edu.ga.Domain.dto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private GroupEntity grupo;

    @ManyToOne
    @JoinColumn(name = "asignatura_id", nullable = false)
    private SubjectEntity asignatura;
}
