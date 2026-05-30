package cesde.edu.ga.repository;

import cesde.edu.ga.model.GroupSubject;
import java.util.List;

public interface GroupSubjectRepository {

    GroupSubject create(GroupSubject groupSubject);

    List<GroupSubject> findAll();

    GroupSubject findById(Long groupSubjectId);

    GroupSubject findByGroupId(Long groupId);

    GroupSubject findBySubjectId(Long subjectId);

    GroupSubject findByTeacherId(Long teacherId);

    boolean update(GroupSubject groupSubject);

    boolean delete(Long groupSubjectId);

    boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId);

    int count();
}
