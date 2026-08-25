package cesde.edu.ga.repository.jpa;

import cesde.edu.ga.entity.PeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<PeriodEntity, Long> {
}
