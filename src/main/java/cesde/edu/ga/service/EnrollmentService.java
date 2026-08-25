package cesde.edu.ga.service;

import cesde.edu.ga.model.Enrollment;
import java.util.List;

public interface EnrollmentService {

    Enrollment create(Enrollment enrollment);

    boolean update(Enrollment enrollment);

    boolean delete(Long enrollmentId);

    Enrollment findById(Long enrollmentId);

    List<Enrollment> findAll();

    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByGroupId(Long groupId);

    List<Enrollment> findByPeriodId(Long periodId);
}