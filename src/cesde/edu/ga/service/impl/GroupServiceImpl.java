package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Group;
import cesde.edu.ga.repository.GroupRepository;
import cesde.edu.ga.service.GroupService;
import cesde.edu.ga.exceptions.GroupExceptions;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        if (group == null) {
            throw new GroupExceptions("Group cannot be null");
        }

        if (isInvalidGroup(group)) {
            throw new GroupExceptions("Invalid group data");
        }

        return groupRepository.create(group);
    }

    @Override
    public boolean update(Group group) {
        if (group == null) {
            throw new GroupExceptions("Group cannot be null");
        }

        if (group.getGroupId() == null || group.getGroupId() <= 0L) {
            throw new GroupExceptions("Group id is invalid");
        }

        if (isInvalidGroup(group)) {
            throw new GroupExceptions("Invalid group data");
        }

        return groupRepository.update(group);
    }

    @Override
    public boolean delete(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            throw new GroupExceptions("Group id is invalid");
        }

        return groupRepository.delete(groupId);
    }

    @Override
    public Group findById(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            throw new GroupExceptions("Group id is invalid");
        }

        Group group = groupRepository.findById(groupId);

        if (group == null) {
            throw GroupExceptions.noEncontrado(groupId);
        }

        return group;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    private boolean isInvalidGroup(Group group) {
        return isBlank(group.getCode())
                || group.getProgramId() == null
                || group.getProgramId() <= 0L
                || group.getPeriodId() == null
                || group.getPeriodId() <= 0L
                || isBlank(group.getSchedule());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}