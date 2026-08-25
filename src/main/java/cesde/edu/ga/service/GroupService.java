package cesde.edu.ga.service;

import cesde.edu.ga.model.Group;
import java.util.List;

public interface GroupService {

    Group create(Group group);

    boolean update(Group group);

    boolean delete(Long groupId);

    Group findById(Long groupId);

    List<Group> findAll();
}