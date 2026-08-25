package cesde.edu.ga.service;

import cesde.edu.ga.model.GroupSubject;
import java.util.List;

public interface GroupSubjectService {

    GroupSubject create(GroupSubject groupSubject);

    boolean update(GroupSubject groupSubject);

    boolean delete(Long groupSubjectId);

    GroupSubject findById(Long groupSubjectId);

    List<GroupSubject> findAll();

    GroupSubject findByGroupId(Long groupId);

    GroupSubject findBySubjectId(Long subjectId);

    GroupSubject findByTeacherId(Long teacherId);

    boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId);
}
