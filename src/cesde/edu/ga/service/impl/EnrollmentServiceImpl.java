package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.repository.EnrollmentRepository;
import cesde.edu.ga.service.EnrollmentService;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private EnrollmentRepository repository;

    public EnrollmentServiceImpl(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollment == null) return null;
        return repository.create(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollment) {
        if (enrollment == null || enrollment.getEnrollmentId() == null) return false;
        return repository.update(enrollment);
    }

    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null) return false;
        return repository.delete(enrollmentId);
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null) return null;
        return repository.findById(enrollmentId);
    }

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        return repository.findByGroupId(groupId);
    }

    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        return repository.findByPeriodId(periodId);
    }
}