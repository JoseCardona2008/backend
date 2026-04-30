package cesde.edu.ga.service;

import cesde.edu.ga.model.Role;
import java.util.List;


public interface RoleService {

    Role create(Role role);

    boolean update(Role role);

    boolean delete(Long roleId);

    Role findById(Long roleId);

    List<Role> findAll();

}
