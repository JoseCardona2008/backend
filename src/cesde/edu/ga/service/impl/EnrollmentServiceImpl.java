package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.EnrollmentExceptions;
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
        if (enrollment == null) {
            throw new EnrollmentExceptions("La matrícula no puede ser nula");
        }

        return repository.create(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollment) {
        if (enrollment == null) {
            throw new EnrollmentExceptions("La matrícula no puede ser nula");
        }

        if (enrollment.getEnrollmentId() == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }

        return repository.update(enrollment);
    }

    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }

        return repository.delete(enrollmentId);
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }

        Enrollment enrollment = repository.findById(enrollmentId);

        if (enrollment == null) {
            throw EnrollmentExceptions.noEncontrada(enrollmentId);
        }

        return enrollment;
    }

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        if (studentId == null) {
            throw new EnrollmentExceptions("El id del estudiante no puede ser nulo");
        }

        return repository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        if (groupId == null) {
            throw new EnrollmentExceptions("El id del grupo no puede ser nulo");
        }

        return repository.findByGroupId(groupId);
    }

    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        if (periodId == null) {
            throw new EnrollmentExceptions("El id del período no puede ser nulo");
        }

        return repository.findByPeriodId(periodId);
    }
}