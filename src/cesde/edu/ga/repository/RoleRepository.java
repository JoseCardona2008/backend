package cesde.edu.ga.repository;

import cesde.edu.ga.model.Role;
import java.util.List;


public interface RoleRepository {
    Role create(Role role);
    Role findById(Role role);
    Role findByName(String name);
    List<Role> findAll();

    boolean delete (Long roleId);
    boolean update(Role role);
    boolean existsByName(String name);
    int count();

    Role findById(Long roleId);
}
