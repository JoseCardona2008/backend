package cesde.edu.ga.Domain.dto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String codigo;

    private Integer creditos;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private TeacherEntity profesor;

}
