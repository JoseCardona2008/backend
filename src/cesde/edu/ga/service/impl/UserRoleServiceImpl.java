package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.UserRole;
import cesde.edu.ga.repository.UserRoleRepository;
import cesde.edu.ga.service.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository repository;

    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (userRole == null) return null;
        return repository.create(userRole);
    }

    @Override
    public boolean update(UserRole userRole) {
        if (userRole == null || userRole.getUserRoleId() == null) return false;
        return repository.update(userRole);
    }

    @Override
    public boolean delete(Long userRoleId) {
        if (userRoleId == null) return false;
        return repository.delete(userRoleId);
    }

    @Override
    public UserRole findById(Long userRoleId) {
        if (userRoleId == null) return null;
        return repository.findById(userRoleId);
    }

    @Override
    public List<UserRole> findAll() {
        return repository.findAll();
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        return repository.findByRoleId(roleId);
    }
}