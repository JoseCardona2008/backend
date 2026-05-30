package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Grade;
import cesde.edu.ga.repository.GradeRepository;
import cesde.edu.ga.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private GradeRepository repository;

    public GradeServiceImpl(GradeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Grade create(Grade grade) {
        if (grade == null) return null;
        return repository.create(grade);
    }

    @Override
    public boolean update(Grade grade) {
        if (grade == null || grade.getGradeId() == null) return false;
        return repository.update(grade);
    }

    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null) return false;
        return repository.delete(gradeId);
    }

    @Override
    public Grade findById(Long gradeId) {
        if (gradeId == null) return null;
        return repository.findById(gradeId);
    }

    @Override
    public List<Grade> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Grade> findByEnrollmentId(Long enrollmentId) {
        return repository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
        return repository.findByGroupSubjectId(groupSubjectId);
    }
}