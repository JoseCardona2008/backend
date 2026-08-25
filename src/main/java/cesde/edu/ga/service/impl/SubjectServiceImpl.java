package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.SubjectExceptions;
import cesde.edu.ga.model.Subject;
import cesde.edu.ga.repository.SubjectRepository;
import cesde.edu.ga.service.SubjectService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    @Override
    public Subject create(Subject subject) {
        validateSubject(subject, false);
        Subject created = subjectRepository.create(subject);
        if (created == null) {
            throw new SubjectExceptions("Error al crear la asignatura. Probablemente código duplicado.");
        }
        return created;
    }
    @Override
    public boolean update(Subject subject) {
        if (subject == null) {
            throw new SubjectExceptions("Subject cannot be null");
        }
        if (subject.getSubjectId() == null || subject.getSubjectId() <= 0L) {
            throw new SubjectExceptions("Subject id is invalid");
        }
        validateSubject(subject, true);
        return subjectRepository.update(subject);
    }
    @Override
    public boolean delete(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            throw new SubjectExceptions("Subject id is invalid");
        }
        return subjectRepository.delete(subjectId);
    }
    @Override
    public Subject findById(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            throw new SubjectExceptions("Subject id is invalid");
        }
        Subject subject = subjectRepository.findById(subjectId);
        if (subject == null) {
            throw SubjectExceptions.noEncontrada(subjectId);
        }
        return subject;
    }
    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
    @Override
    public Subject findByCode(String code) {
        if (code == null || code.trim().isBlank()) {
            throw new SubjectExceptions("Code cannot be null or empty");
        }
        return subjectRepository.findByCode(code);
    }
    private void validateSubject(Subject subject, boolean isUpdate) {
        if (subject == null) {
            throw new SubjectExceptions("Subject cannot be null");
        }
        if (isBlank(subject.getName())) {
            throw new SubjectExceptions("El nombre de la asignatura es obligatorio");
        }
        if (isBlank(subject.getCode())) {
            throw new SubjectExceptions("El código de la asignatura es obligatorio");
        }
        if (subject.getCredits() == null || subject.getCredits() <= 0) {
            throw new SubjectExceptions("Los créditos de la asignatura deben ser mayores que cero");
        }
        if (subject.getProgramId() == null || subject.getProgramId() <= 0L) {
            throw new SubjectExceptions("El id del programa es inválido o nulo");
        }
        // Validar código único
        Subject existing = subjectRepository.findByCode(subject.getCode());
        if (existing != null) {
            if (!isUpdate || !existing.getSubjectId().equals(subject.getSubjectId())) {
                throw SubjectExceptions.codigoDuplicado(subject.getCode());
            }
        }
    }
    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}