package cesde.edu.ga.repository;

import cesde.edu.ga.model.Teacher;
import java.util.List;

public interface TeacherRepository {

    Teacher create(Teacher teacher);

    List<Teacher> findAll();

    Teacher findById(Long teacherId);

    Teacher findByDocumentNumber(String documentNumber);

    boolean update(Teacher updatedTeacher);

    boolean delete(Long teacherId);

    boolean existsByDocumentNumber(String documentNumber);

    int count();
}
