package cesde.edu.ga.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String horario;
    private String salon;

    @ManyToOne
    @JoinColumn(name = "programa_id", nullable = false)
    private ProgramEntity programa;

    @ManyToOne
    @JoinColumn(name = "periodo_id", nullable = false)
    private PeriodEntity periodo;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private TeacherEntity profesor;
}
