package cesde.edu.ga.repository;

import cesde.edu.ga.model.UserRole;
import java.util.List;

public interface UserRoleRepository {

    UserRole create(UserRole userRole);

    UserRole findById(Long userRoleId);

    List<UserRole> findAll();

    List<UserRole> findByUserId(Long userId);

    List<UserRole> findByRoleId(Long roleId);

    boolean update(UserRole userRole);

    boolean delete(Long userRoleId);

    int count();
}
