package cesde.edu.ga.service;

import cesde.edu.ga.model.Subject;
import java.util.List;

public interface SubjectService {

    Subject create(Subject subject);

    boolean update(Subject subject);

    boolean delete(Long subjectId);

    Subject findById(Long subjectId);

    List<Subject> findAll();

    Subject findByCode(String code);
}
