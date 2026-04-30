package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Group;
import cesde.edu.ga.repository.GroupRepository;
import cesde.edu.ga.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        if (isInvalidGroup(group)) {
            return null;
        }
        return groupRepository.create(group);
    }

    @Override
    public boolean update(Group group) {
        if (isInvalidGroup(group)
                || group.getGroupId() == null
                || group.getGroupId() <= 0L) {
            return false;
        }
        return groupRepository.update(group);
    }

    @Override
    public boolean delete(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            return false;
        }
        return groupRepository.delete(groupId);
    }

    @Override
    public Group findById(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            return null;
        }
        return groupRepository.findById(groupId);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }


    private boolean isInvalidGroup(Group group) {
        return group == null
                || isBlank(group.getCode())
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