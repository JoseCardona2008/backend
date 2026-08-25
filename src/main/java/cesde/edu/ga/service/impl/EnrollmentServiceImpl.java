package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.EnrollmentExceptions;
import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.model.Group;
import cesde.edu.ga.model.Student;
import cesde.edu.ga.repository.EnrollmentRepository;
import cesde.edu.ga.repository.GroupRepository;
import cesde.edu.ga.repository.StudentRepository;
import cesde.edu.ga.service.EnrollmentService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repository;
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    public EnrollmentServiceImpl(EnrollmentRepository repository, StudentRepository studentRepository, GroupRepository groupRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }
    @Override
    public Enrollment create(Enrollment enrollment) {
        validateEnrollment(enrollment);
        return repository.create(enrollment);
    }
    @Override
    public boolean update(Enrollment enrollment) {
        if (enrollment == null) {
            throw new EnrollmentExceptions("La matrícula no puede ser nula");
        }
        if (enrollment.getEnrollmentId() == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }
        validateEnrollment(enrollment);
        return repository.update(enrollment);
    }
    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }
        return repository.delete(enrollmentId);
    }
    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null) {
            throw new EnrollmentExceptions("El id de la matrícula no puede ser nulo");
        }
        Enrollment enrollment = repository.findById(enrollmentId);
        if (enrollment == null) {
            throw EnrollmentExceptions.noEncontrada(enrollmentId);
        }
        return enrollment;
    }
    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }
    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        if (studentId == null) {
            throw new EnrollmentExceptions("El id del estudiante no puede ser nulo");
        }
        return repository.findByStudentId(studentId);
    }
    @Override
    public List<Enrollment> findByGroupId(Long groupId) {
        if (groupId == null) {
            throw new EnrollmentExceptions("El id del grupo no puede ser nulo");
        }
        return repository.findByGroupId(groupId);
    }
    @Override
    public List<Enrollment> findByPeriodId(Long periodId) {
        if (periodId == null) {
            throw new EnrollmentExceptions("El id del período no puede ser nulo");
        }
        return repository.findByPeriodId(periodId);
    }
    private void validateEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            throw new EnrollmentExceptions("La matrícula no puede ser nula");
        }
        if (enrollment.getStudentId() == null) {
            throw new EnrollmentExceptions("El id del estudiante es obligatorio");
        }
        if (enrollment.getGroupId() == null) {
            throw new EnrollmentExceptions("El id del grupo es obligatorio");
        }
        // 1. Validar que el estudiante exista
        Student student = studentRepository.findById(enrollment.getStudentId());
        if (student == null) {
            throw new EnrollmentExceptions("El estudiante con id " + enrollment.getStudentId() + " no existe.");
        }
        // 2. Validar que el grupo exista
        Group group = groupRepository.findById(enrollment.getGroupId());
        if (group == null) {
            throw new EnrollmentExceptions("El grupo con id " + enrollment.getGroupId() + " no existe.");
        }
        // 3. Validar que no esté matriculado dos veces
        List<Enrollment> studentEnrollments = repository.findByStudentId(enrollment.getStudentId());
        for (Enrollment existing : studentEnrollments) {
            if (existing.getGroupId().equals(enrollment.getGroupId())) {
                if (enrollment.getEnrollmentId() == null || !enrollment.getEnrollmentId().equals(existing.getEnrollmentId())) {
                    throw EnrollmentExceptions.duplicada(enrollment.getStudentId(), enrollment.getGroupId());
                }
            }
        }
        // 4. Validar que haya cupos disponibles
        List<Enrollment> groupEnrollments = repository.findByGroupId(enrollment.getGroupId());
        int count = 0;
        for (Enrollment existing : groupEnrollments) {
            if (enrollment.getEnrollmentId() == null || !enrollment.getEnrollmentId().equals(existing.getEnrollmentId())) {
                count++;
            }
        }
        Integer capacity = group.getCapacity();
        if (capacity == null) {
            capacity = 30; // fallback
        }
        if (count >= capacity) {
            throw new EnrollmentExceptions("No hay cupos disponibles en el grupo con id: " + enrollment.getGroupId()
                    + " (Capacidad máxima: " + capacity + ")");
        }
    }
}