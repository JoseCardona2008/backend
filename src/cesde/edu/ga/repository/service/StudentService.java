package cesde.edu.ga.repository.service;

import cesde.edu.ga.model.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    boolean update(Student student);

    boolean delete(Long studentId);

    Student findById(Long studentId);

    List<Student> findAll();
}
