package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Role;
import cesde.edu.ga.repository.RoleRepository;
import cesde.edu.ga.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        if (isInvalidRole(role)) {
            return null;
        }
        return roleRepository.create(role);
    }

    @Override
    public boolean update(Role role) {
        if (isInvalidRole(role)
                || role.getRoleId() == null
                || role.getRoleId() <= 0L) {
            return false;
        }
        return roleRepository.update(role);
    }

    @Override
    public boolean delete(Long roleId) {
        if (roleId == null || roleId <= 0L) {
            return false;
        }
        return roleRepository.delete(roleId);
    }

    @Override
    public Role findById(Long roleId) {
        if (roleId == null || roleId <= 0L) {
            return null;
        }
        return roleRepository.findById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    private boolean isInvalidRole(Role role) {
        return role == null
                || isBlank(role.getName())
                || isBlank(role.getDescription());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}