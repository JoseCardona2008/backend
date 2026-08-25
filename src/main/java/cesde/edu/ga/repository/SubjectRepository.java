package cesde.edu.ga.repository;

import cesde.edu.ga.model.Subject;
import java.util.List;

public interface SubjectRepository {

    Subject create(Subject subject);

    List<Subject> findAll();

    Subject findById(Long subjectId);

    Subject findByCode(String code);

    boolean update(Subject updatedSubject);

    boolean delete(Long subjectId);

    boolean existsByCode(String code);

    int count();
}
