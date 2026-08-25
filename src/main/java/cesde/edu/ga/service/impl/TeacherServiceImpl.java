package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.TeacherExceptions;
import cesde.edu.ga.model.Teacher;
import cesde.edu.ga.repository.TeacherRepository;
import cesde.edu.ga.service.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Override
    public Teacher create(Teacher teacher) {
        validateTeacher(teacher, false);
        Teacher created = teacherRepository.create(teacher);
        if (created == null) {
            throw new TeacherExceptions("Error al crear el docente. Probablemente conflicto de documento.");
        }
        return created;
    }
    @Override
    public boolean update(Teacher teacher) {
        if (teacher == null) {
            throw new TeacherExceptions("Teacher cannot be null");
        }
        if (teacher.getTeacherId() == null || teacher.getTeacherId() <= 0L) {
            throw new TeacherExceptions("Teacher id is invalid");
        }
        validateTeacher(teacher, true);
        return teacherRepository.update(teacher);
    }
    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            throw new TeacherExceptions("Teacher id is invalid");
        }
        return teacherRepository.delete(teacherId);
    }
    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            throw new TeacherExceptions("Teacher id is invalid");
        }
        Teacher teacher = teacherRepository.findById(teacherId);
        if (teacher == null) {
            throw TeacherExceptions.noEncontrado(teacherId);
        }
        return teacher;
    }
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            throw new TeacherExceptions("Document number cannot be null or empty");
        }
        return teacherRepository.findByDocumentNumber(documentNumber);
    }
    private void validateTeacher(Teacher teacher, boolean isUpdate) {
        if (teacher == null) {
            throw new TeacherExceptions("Teacher cannot be null");
        }
        if (isBlank(teacher.getFirstName()) || isBlank(teacher.getLastName())) {
            throw new TeacherExceptions("El nombre y apellido del docente son obligatorios");
        }
        if (isBlank(teacher.getDocumentType()) || isBlank(teacher.getDocumentNumber())) {
            throw new TeacherExceptions("El tipo y número de documento son obligatorios");
        }
        if (isBlank(teacher.getStatus())) {
            throw new TeacherExceptions("El estado del docente es obligatorio");
        }
        if (isBlank(teacher.getSpecialty())) {
            throw new TeacherExceptions("La especialidad del docente es obligatoria");
        }
        // Validar documento único
        Teacher existing = teacherRepository.findByDocumentNumber(teacher.getDocumentNumber());
        if (existing != null) {
            if (!isUpdate || !existing.getTeacherId().equals(teacher.getTeacherId())) {
                throw new TeacherExceptions("Ya existe un docente con el documento: " + teacher.getDocumentNumber());
            }
        }
    }
    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}