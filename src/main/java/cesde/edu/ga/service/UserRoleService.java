package cesde.edu.ga.service;

import cesde.edu.ga.model.UserRole;
import java.util.List;

public interface UserRoleService {

    UserRole create(UserRole userRole);

    boolean update(UserRole userRole);

    boolean delete(Long userRoleId);

    UserRole findById(Long userRoleId);

    List<UserRole> findAll();

    List<UserRole> findByUserId(Long userId);

    List<UserRole> findByRoleId(Long roleId);
}