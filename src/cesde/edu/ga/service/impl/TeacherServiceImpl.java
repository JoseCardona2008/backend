package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Teacher;
import cesde.edu.ga.repository.TeacherRepository;
import cesde.edu.ga.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        if (isInvalidTeacher(teacher)) {
            return null;
        }
        return teacherRepository.create(teacher);
    }

    @Override
    public boolean update(Teacher teacher) {
        if (isInvalidTeacher(teacher)
                || teacher.getTeacherId() == null
                || teacher.getTeacherId() <= 0L) {
            return false;
        }
        return teacherRepository.update(teacher);
    }

    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            return false;
        }
        return teacherRepository.delete(teacherId);
    }

    @Override
    public Teacher findById(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            return null;
        }
        return teacherRepository.findById(teacherId);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            return null;
        }
        return teacherRepository.findByDocumentNumber(documentNumber);
    }

    private boolean isInvalidTeacher(Teacher teacher) {
        return teacher == null
                || isBlank(teacher.getFirstName())
                || isBlank(teacher.getLastName())
                || isBlank(teacher.getDocumentType())
                || isBlank(teacher.getDocumentNumber())
                || isBlank(teacher.getStatus());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}
