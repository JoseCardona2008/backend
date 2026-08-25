package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Role;
import cesde.edu.ga.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryInMemory implements RoleRepository {
    private final List<Role> roles;
    private Long nextRoleId;
    public  RoleRepositoryInMemory() {
        this.roles = new ArrayList<>();
        this.nextRoleId = 1L;
    }
    @Override
    public Role create(Role role) {
        if(role==null){
            return null;
        }
        if (existsByName(role.getName())) {
            return null;
        }
        role.setRoleId(nextRoleId++);
        roles.add(role);
        return role;
    }
    @Override
    public Role findById(Role role) {
        return null;
    }
    @Override
    public boolean existsByName(String name) {
        if (name==null || name.isBlank()) {
            return false;
        }
        return findByName(name)!=null;
    }
    @Override
    public Role findByName(String name) {
        if (name==null || name.isBlank()) {
            return null;
        }
        for (Role role : roles) {
            if (name.equals(role.getName())) {
                return role;
            }
        }
        return null;
    }
    @Override
    public List<Role> findAll() {
        return new ArrayList<>(roles);
    }
    @Override
    public Role findById(Long roleId) {
        if (roleId==null || roleId <= 0) {
            return null;
        }
        for (Role role : roles) {
            if (roleId.equals(role.getRoleId())) {
                return role;
            }
        }
        return null;
    }
    @Override
    public boolean delete(Long roleId) {
        Role role = findById(roleId);
        if (role == null) {
            return false;
        }
        roles.remove(role);
        return true;
    }
    @Override
    public int count() {
        return roles.size();
    }
    @Override
    public boolean update(Role updatedRole) {
        if (updatedRole == null) return false;
        for (int i = 0; i < roles.size(); i++) {
            if (updatedRole.getRoleId().equals(roles.get(i).getRoleId())) {
                roles.set(i, updatedRole);
                return true;
            }
        }
        return false;
    }
}
