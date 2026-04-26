package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.Group;
import cesde.edu.ga.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryInMemory implements GroupRepository {

    private List<Group> groups;
    private Long nextGroupId;

    public GroupRepositoryInMemory() {
        this.groups = new ArrayList<>();
        this.nextGroupId = 1L;
    }

    @Override
    public Group create(Group group) {

        if (group == null) return null;

        if (existsByCode(group.getCode())) return null;

        group.setGroupId(nextGroupId++);
        groups.add(group);
        return group;
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isBlank()) return false;
        return findByCode(code) != null;
    }

    @Override
    public Group findByCode(String code) {
        if (code == null || code.isBlank()) return null;

        for (Group group : groups) {
            if (code.equals(group.getCode())) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groups);
    }

    @Override
    public Group findById(Long groupId) {
        if (groupId == null || groupId <= 0) return null;

        for (Group group : groups) {
            if (groupId.equals(group.getGroupId())) {
                return group;
            }
        }
        return null;
    }



    @Override
    public int count() {
        return groups.size();
    }

    @Override
    public boolean update(Group updatedGroup) {

        if (updatedGroup == null) return false;

        for (int i = 0; i < groups.size(); i++) {
            if (updatedGroup.getGroupId().equals(groups.get(i).getGroupId())) {
                groups.set(i, updatedGroup);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long groupId) {
        Group group = findById(groupId);
        if (group == null) return false;

        groups.remove(group);
        return true;

    }
}