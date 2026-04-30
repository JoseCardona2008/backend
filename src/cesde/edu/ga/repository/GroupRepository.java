package cesde.edu.ga.repository;

import cesde.edu.ga.model.Group;
import java.util.List;

public interface GroupRepository {

    Group create(Group group);
    Group  findById(Long groupId);
    Group findByCode(String code);
    List<Group> findAll();
    boolean update(Group group);
    boolean delete(Long groupId);
    boolean existsByCode(String  code);
    int count();
}
