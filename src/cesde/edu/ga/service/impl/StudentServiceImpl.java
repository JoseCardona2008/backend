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
        validateStudent(student, false);

        Student created = studentRepository.create(student);
        if (created == null) {
            throw new StudentExceptions("Error al crear el estudiante. Probablemente conflicto de documento.");
        }
        return created;
    }

    @Override
    public boolean update(Student student) {
        if (student == null) {
            throw new StudentExceptions("Student cannot be null");
        }

        if (student.getStudentId() == null || student.getStudentId() <= 0L) {
            throw new StudentExceptions("Student id is invalid");
        }

        validateStudent(student, true);

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

    private void validateStudent(Student student, boolean isUpdate) {
        if (student == null) {
            throw new StudentExceptions("Student cannot be null");
        }

        if (isBlank(student.getFirstName()) || isBlank(student.getLastName())) {
            throw new StudentExceptions("El nombre y apellido del estudiante son obligatorios");
        }

        if (isBlank(student.getDocumentType()) || isBlank(student.getDocumentNumber())) {
            throw new StudentExceptions("El tipo y número de documento son obligatorios");
        }

        if (isBlank(student.getStatus())) {
            throw new StudentExceptions("El estado del estudiante es obligatorio");
        }

        // 1. Validar documento único
        Student existing = studentRepository.findByDocumentNumber(student.getDocumentNumber());
        if (existing != null) {
            if (!isUpdate || !existing.getStudentId().equals(student.getStudentId())) {
                throw new StudentExceptions("Ya existe un estudiante con el documento: " + student.getDocumentNumber());
            }
        }

        // 2. Validar edad válida (fecha de nacimiento válida y coherente)
        if (isBlank(student.getBirthDate())) {
            throw new StudentExceptions("La fecha de nacimiento es obligatoria");
        }
        try {
            java.time.LocalDate birth = java.time.LocalDate.parse(student.getBirthDate());
            if (birth.isAfter(java.time.LocalDate.now())) {
                throw StudentExceptions.fechaNacimientoInvalida(student.getBirthDate() + " (Fecha en el futuro)");
            }
            int age = java.time.Period.between(birth, java.time.LocalDate.now()).getYears();
            if (age < 5 || age > 120) {
                throw StudentExceptions.fechaNacimientoInvalida(student.getBirthDate() + " (Debe tener entre 5 y 120 años)");
            }
        } catch (java.time.format.DateTimeParseException e) {
            throw StudentExceptions.fechaNacimientoInvalida(student.getBirthDate() + " (Formato inválido)");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}