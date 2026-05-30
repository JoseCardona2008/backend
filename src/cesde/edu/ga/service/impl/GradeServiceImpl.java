package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Grade;
import cesde.edu.ga.repository.GradeRepository;
import cesde.edu.ga.service.GradeService;
import cesde.edu.ga.exceptions.GradeExceptions;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private GradeRepository repository;

    public GradeServiceImpl(GradeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Grade create(Grade grade) {
        if (grade == null) {
            throw new GradeExceptions("Grade cannot be null");
        }

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
}