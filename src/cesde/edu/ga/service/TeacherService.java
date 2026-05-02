package cesde.edu.ga.service;

import cesde.edu.ga.model.Teacher;
import java.util.List;

public interface TeacherService {

    Teacher create(Teacher teacher);

    boolean update(Teacher teacher);

    boolean delete(Long teacherId);

    Teacher findById(Long teacherId);

    List<Teacher> findAll();

    Teacher findByDocumentNumber(String documentNumber);
}
