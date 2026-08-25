package cesde.edu.ga.repository;

import cesde.edu.ga.model.Enrollment;
import java.util.List;

public interface EnrollmentRepository {

    Enrollment create(Enrollment enrollment);

    Enrollment findById(Long enrollmentId);

    List<Enrollment> findAll();

    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByGroupId(Long groupId);

    List<Enrollment> findByPeriodId(Long periodId);

    boolean update(Enrollment enrollment);

    boolean delete(Long enrollmentId);

    boolean existsByStudentIdAndGroupIdAndPeriodId(Long studentId, Long groupId, Long periodId);

    int count();
}