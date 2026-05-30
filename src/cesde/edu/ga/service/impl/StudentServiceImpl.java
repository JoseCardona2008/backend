package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Student;
import cesde.edu.ga.repository.StudentRepository;
import cesde.edu.ga.service.StudentService;
import cesde.edu.ga.exceptions.StudentExceptions;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (student == null) {
            throw new StudentExceptions("Student cannot be null");
        }

        if (isInvalidStudent(student)) {
            throw new StudentExceptions("Invalid student data");
        }

        return studentRepository.create(student);
    }

    @Override
    public boolean update(Student student) {
        if (student == null) {
            throw new StudentExceptions("Student cannot be null");
        }

        if (student.getStudentId() == null || student.getStudentId() <= 0L) {
            throw new StudentExceptions("Student id is invalid");
        }

        if (isInvalidStudent(student)) {
            throw new StudentExceptions("Invalid student data");
        }

        return studentRepository.update(student);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            throw new StudentExceptions("Student id is invalid");
        }

        return studentRepository.delete(studentId);
    }

    @Override
    public Student findById(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            throw new StudentExceptions("Student id is invalid");
        }

        Student student = studentRepository.findById(studentId);

        if (student == null) {
            throw StudentExceptions.noEncontrado(studentId);
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            throw new StudentExceptions("Document number cannot be null or empty");
        }

        return studentRepository.findByDocumentNumber(documentNumber);
    }

    private boolean isInvalidStudent(Student student) {
        return isBlank(student.getFirstName())
                || isBlank(student.getLastName())
                || isBlank(student.getDocumentType())
                || isBlank(student.getDocumentNumber())
                || isBlank(student.getBirthDate())
                || isBlank(student.getStatus());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}