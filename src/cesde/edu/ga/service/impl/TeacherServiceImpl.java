package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Teacher;
import cesde.edu.ga.repository.TeacherRepository;
import cesde.edu.ga.service.TeacherService;
import cesde.edu.ga.exceptions.TeacherExceptions;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        if (teacher == null) {
            throw new TeacherExceptions("Teacher cannot be null");
        }

        if (isInvalidTeacher(teacher)) {
            throw new TeacherExceptions("Invalid teacher data");
        }

        return teacherRepository.create(teacher);
    }

    @Override
    public boolean update(Teacher teacher) {
        if (teacher == null) {
            throw new TeacherExceptions("Teacher cannot be null");
        }

        if (teacher.getTeacherId() == null || teacher.getTeacherId() <= 0L) {
            throw new TeacherExceptions("Teacher id is invalid");
        }

        if (isInvalidTeacher(teacher)) {
            throw new TeacherExceptions("Invalid teacher data");
        }

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

    private boolean isInvalidTeacher(Teacher teacher) {
        return isBlank(teacher.getFirstName())
                || isBlank(teacher.getLastName())
                || isBlank(teacher.getDocumentType())
                || isBlank(teacher.getDocumentNumber())
                || isBlank(teacher.getStatus());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}