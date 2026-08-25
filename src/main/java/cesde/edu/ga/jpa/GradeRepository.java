package cesde.edu.ga.jpa;

import cesde.edu.ga.Domain.dto.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}
