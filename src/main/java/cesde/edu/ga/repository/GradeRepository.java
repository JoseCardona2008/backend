package cesde.edu.ga.repository;

import cesde.edu.ga.model.Grade;
import java.util.List;

public interface GradeRepository {

    Grade create(Grade grade);

    Grade findById(Long gradeId);

    List<Grade> findAll();

    List<Grade> findByEnrollmentId(Long enrollmentId);

    List<Grade> findByGroupSubjectId(Long groupSubjectId);

    boolean update(Grade grade);

    boolean delete(Long gradeId);

    int count();
}