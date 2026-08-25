package cesde.edu.ga.jpa;

import cesde.edu.ga.Domain.dto.entity.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Long> {
}
