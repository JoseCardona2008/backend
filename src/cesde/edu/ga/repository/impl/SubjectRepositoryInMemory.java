package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Subject;
import cesde.edu.ga.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryInMemory implements SubjectRepository {

    private List<Subject> subjects;
    private Long nextSubjectId;

    public SubjectRepositoryInMemory(){
        this.subjects = new ArrayList<>();
        this.nextSubjectId = 1L;
    }

    @Override
    public Subject create(Subject subject){

        if (subject == null){
            return null;
        }

        if (existsByCode(subject.getCode())){
            return null;
        }

        subject.setSubjectId(nextSubjectId++);
        subjects.add(subject);
        return subject;
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isEmpty()){
            return false;
        }
        return findByCode(code) != null;
    }

    @Override
    public Subject findByCode(String code) {
        if (code == null || code.isBlank()){
            return null;
        }

        for (Subject subject : subjects) {
            if (code.equals(subject.getCode())) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects);
    }

    @Override
    public Subject findById(Long subjectId) {
        if (subjectId == null || subjectId <= 0){
            return null;
        }
        for (Subject subject : subjects) {
            if (subjectId.equals(subject.getSubjectId())) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long subjectId) {
        Subject subject = findById(subjectId);
        if (subject == null) return false;
        subjects.remove(subject);
        return true;
    }

    @Override
    public int count() {
        return subjects.size();
    }

    @Override
    public boolean update(Subject updatedSubject) {
        if (updatedSubject == null) return false;
        if (findByCode(updatedSubject.getCode()) != null){
            return false;
        }

        for (int i = 0; i < subjects.size(); i++) {
            if (updatedSubject.getSubjectId().equals(subjects.get(i).getSubjectId())) {
                subjects.set(i, updatedSubject);
                return true;
            }
        }
        return false;
    }
}
