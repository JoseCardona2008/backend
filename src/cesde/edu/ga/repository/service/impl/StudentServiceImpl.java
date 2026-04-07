package cesde.edu.ga.repository.service.impl;

import cesde.edu.ga.model.Student;
import cesde.edu.ga.repository.StudentRepository;
import cesde.edu.ga.repository.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (isInvalidStudent(student) ||
                studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }

        return studentRepository.create(student);
    }

    @Override
    public boolean update(Student studentUpdate) {
        if (studentUpdate == null ||
                studentUpdate.getStudentId() == null ||
                studentUpdate.getStudentId() <= 0L ||
                isInvalidStudent(studentUpdate)) {
            return false;
        }
        if (studentRepository.existsByDocumentNumber(studentUpdate.getDocumentNumber())) {
            return false;
        }

        return studentRepository.update(studentUpdate);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            return false;
        }
        return studentRepository.delete(studentId);
    }

    @Override
    public Student findById(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            return null;
        }
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public boolean isInvalidStudent(Student student) {
        return student == null
                || isBlank(student.getDocumentNumber())
                || isBlank(student.getFirstName())
                || isBlank(student.getLastName())
                || isBlank(student.getBirthDate())
                || student.getStatus() == null;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}