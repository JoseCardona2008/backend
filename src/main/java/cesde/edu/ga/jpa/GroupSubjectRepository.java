package cesde.edu.ga.jpa;

import cesde.edu.ga.Domain.dto.entity.GroupSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSubjectRepository extends JpaRepository<GroupSubjectEntity, Long> {
}
