package cesde.edu.ga.service;

import cesde.edu.ga.model.Grade;
import java.util.List;

public interface GradeService {

    Grade create(Grade grade);

    boolean update(Grade grade);

    boolean delete(Long gradeId);

    Grade findById(Long gradeId);

    List<Grade> findAll();

    List<Grade> findByEnrollmentId(Long enrollmentId);

    List<Grade> findByGroupSubjectId(Long groupSubjectId);
}