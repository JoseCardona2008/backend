package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Grade;
import cesde.edu.ga.repository.GradeRepository;

import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryInMemory implements GradeRepository {

    private List<Grade> grades;
    private Long nextId;

    public GradeRepositoryInMemory() {
        this.grades = new ArrayList<>();
        this.nextId = 1L;
    }

    @Override
    public Grade create(Grade grade) {
        if (grade == null) return null;

        grade.setGradeId(nextId++);
        grades.add(grade);
        return grade;
    }

    @Override
    public Grade findById(Long gradeId) {
        if (gradeId == null) return null;

        for (Grade g : grades) {
            if (gradeId.equals(g.getGradeId())) {
                return g;
            }
        }
        return null;
    }

    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades);
    }

    @Override
    public List<Grade> findByEnrollmentId(Long enrollmentId) {
        List<Grade> result = new ArrayList<>();

        for (Grade g : grades) {
            if (enrollmentId.equals(g.getEnrollmentId())) {
                result.add(g);
            }
        }
        return result;
    }

    @Override
    public List<Grade> findByGroupSubjectId(Long groupSubjectId) {
        List<Grade> result = new ArrayList<>();

        for (Grade g : grades) {
            if (groupSubjectId.equals(g.getGroupSubjectId())) {
                result.add(g);
            }
        }
        return result;
    }

    @Override
    public boolean update(Grade grade) {
        if (grade == null) return false;

        for (int i = 0; i < grades.size(); i++) {
            if (grade.getGradeId().equals(grades.get(i).getGradeId())) {
                grades.set(i, grade);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long gradeId) {
        Grade g = findById(gradeId);
        if (g == null) return false;

        grades.remove(g);
        return true;
    }

    @Override
    public int count() {
        return grades.size();
    }
}