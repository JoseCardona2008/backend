package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.UserRole;
import cesde.edu.ga.repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRoleRepositoryInMemory implements UserRoleRepository {

    private List<UserRole> userRoles;
    private Long nextId;

    public UserRoleRepositoryInMemory() {
        this.userRoles = new ArrayList<>();
        this.nextId = 1L;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (userRole == null) return null;

        userRole.setUserRoleId(nextId++);
        userRoles.add(userRole);
        return userRole;
    }

    @Override
    public UserRole findById(Long userRoleId) {
        if (userRoleId == null) return null;

        for (UserRole ur : userRoles) {
            if (userRoleId.equals(ur.getUserRoleId())) {
                return ur;
            }
        }
        return null;
    }

    @Override
    public List<UserRole> findAll() {
        return new ArrayList<>(userRoles);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        List<UserRole> result = new ArrayList<>();

        for (UserRole ur : userRoles) {
            if (userId.equals(ur.getUserId())) {
                result.add(ur);
            }
        }
        return result;
    }

    @Override
    public List<UserRole> findByRoleId(Long roleId) {
        List<UserRole> result = new ArrayList<>();

        for (UserRole ur : userRoles) {
            if (roleId.equals(ur.getRoleId())) {
                result.add(ur);
            }
        }
        return result;
    }

    @Override
    public boolean update(UserRole userRole) {
        if (userRole == null) return false;

        for (int i = 0; i < userRoles.size(); i++) {
            if (userRole.getUserRoleId().equals(userRoles.get(i).getUserRoleId())) {
                userRoles.set(i, userRole);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long userRoleId) {
        UserRole ur = findById(userRoleId);
        if (ur == null) return false;

        userRoles.remove(ur);
        return true;
    }

    @Override
    public int count() {
        return userRoles.size();
    }
}