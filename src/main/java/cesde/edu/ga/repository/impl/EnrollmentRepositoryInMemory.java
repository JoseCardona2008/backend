package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.repository.EnrollmentRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentRepositoryInMemory implements EnrollmentRepository {
    private List<Enrollment> enrollments;
    private Long nextId;
    public EnrollmentRepositoryInMemory() {
        this.enrollments = new ArrayList<>();
        this.nextId = 1L;
    }
    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollment == null) return null;
        enrollment.setEnrollmentId(nextId++);
        enrollments.add(enrollment);
        return enrollment;
    }
    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null) return null;
        for (Enrollment e : enrollments) {
            if (enrollmentId.equals(e.getEnrollmentId())) {
                return e;
            }
        }
        return null;
    }
    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments);
    }
    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (studentId.equals(e.getStudentId())) {
                result.add(e);
            }
        }
        return result;
    }
    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (groupId.equals(e.getGroupId())) {
                result.add(e);
            }
        }
        return result;
    }
    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (periodId.equals(e.getPeriodId())) {
                result.add(e);
            }
        }
        return result;
    }
    @Override
    public boolean update(Enrollment enrollment) {
        if (enrollment == null) return false;
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollment.getEnrollmentId().equals(enrollments.get(i).getEnrollmentId())) {
                enrollments.set(i, enrollment);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(Long enrollmentId) {
        Enrollment e = findById(enrollmentId);
        if (e == null) return false;
        enrollments.remove(e);
        return true;
    }
    @Override
    public boolean existsByStudentIdAndGroupIdAndPeriodId(Long studentId, Long groupId, Long periodId) {
        for (Enrollment e : enrollments) {
            if (studentId.equals(e.getStudentId())
                    && groupId.equals(e.getGroupId())
                    && periodId.equals(e.getPeriodId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int count() {
        return enrollments.size();
    }
}
