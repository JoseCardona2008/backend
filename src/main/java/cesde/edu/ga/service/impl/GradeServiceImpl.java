package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.GradeExceptions;
import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.model.Grade;
import cesde.edu.ga.repository.EnrollmentRepository;
import cesde.edu.ga.repository.GradeRepository;
import cesde.edu.ga.service.GradeService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepository repository;
    private final EnrollmentRepository enrollmentRepository;
    public GradeServiceImpl(GradeRepository repository, EnrollmentRepository enrollmentRepository) {
        this.repository = repository;
        this.enrollmentRepository = enrollmentRepository;
    }
    @Override
    public Grade create(Grade grade) {
        validateGrade(grade);
        return repository.create(grade);
    }
    @Override
    public boolean update(Grade grade) {
        if (grade == null) {
            throw new GradeExceptions("Grade cannot be null");
        }
        if (grade.getGradeId() == null) {
            throw new GradeExceptions("Grade id cannot be null");
        }
        validateGrade(grade);
        return repository.update(grade);
    }
    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null) {
            throw new GradeExceptions("Grade id cannot be null");
        }
        return repository.delete(gradeId);
    }
    @Override
    public Grade findById(Long gradeId) {
        if (gradeId == null) {
            throw new GradeExceptions("Grade id cannot be null");
        }
        Grade grade = repository.findById(gradeId);
        if (grade == null) {
            throw GradeExceptions.noEncontrada(gradeId);
        }
        return grade;
    }
    @Override
    public List<Grade> findAll() {
        return repository.findAll();
    }
    @Override
    public List<Grade> findByEnrollmentId(Long enrollmentId) {
        if (enrollmentId == null) {
            throw new GradeExceptions("Enrollment id cannot be null");
        }
        return repository.findByEnrollmentId(enrollmentId);
    }
    @Override
    public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
        if (groupSubjectId == null) {
            throw new GradeExceptions("GroupSubject id cannot be null");
        }
        return repository.findByGroupSubjectId(groupSubjectId);
    }
    private void validateGrade(Grade grade) {
        if (grade == null) {
            throw new GradeExceptions("Grade cannot be null");
        }
        if (grade.getEnrollmentId() == null) {
            throw new GradeExceptions("El id de la matrícula es obligatorio");
        }
        // 1. Validar que la nota esté dentro del rango permitido (0.0 a 5.0)
        if (grade.getFinalScore() == null || grade.getFinalScore() < 0.0 || grade.getFinalScore() > 5.0) {
            throw GradeExceptions.notaInvalida(grade.getFinalScore());
        }
        // 2. Validar que la matrícula exista
        Enrollment enrollment = enrollmentRepository.findById(grade.getEnrollmentId());
        if (enrollment == null) {
            throw new GradeExceptions("La matrícula con id " + grade.getEnrollmentId() + " no existe.");
        }
    }
}