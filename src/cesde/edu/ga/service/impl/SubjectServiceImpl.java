package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Subject;
import cesde.edu.ga.repository.SubjectRepository;
import cesde.edu.ga.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        if (isInvalidSubject(subject)) {
            return null;
        }
        return subjectRepository.create(subject);
    }

    @Override
    public boolean update(Subject subject) {
        if (isInvalidSubject(subject)
                || subject.getSubjectId() == null
                || subject.getSubjectId() <= 0L) {
            return false;
        }
        return subjectRepository.update(subject);
    }

    @Override
    public boolean delete(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            return false;
        }
        return subjectRepository.delete(subjectId);
    }

    @Override
    public Subject findById(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            return null;
        }
        return subjectRepository.findById(subjectId);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            return null;
        }
        return subjectRepository.findByCode(code);
    }

    private boolean isInvalidSubject(Subject subject) {
        return subject == null
                || isBlank(subject.getCode())
                || isBlank(subject.getName())
                || subject.getCredits() == null
                || subject.getCredits() <= 0
                || subject.getProgramId() == null
                || subject.getProgramId() <= 0L;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}
