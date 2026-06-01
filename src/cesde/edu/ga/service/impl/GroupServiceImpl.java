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
        validateGroup(group);

        Group created = groupRepository.create(group);
        if (created == null) {
            throw new GroupExceptions("Error al crear el grupo. Probablemente código duplicado.");
        }
        return created;
    }

    @Override
    public boolean update(Group group) {
        if (group == null) {
            throw new GroupExceptions("Group cannot be null");
        }

        if (group.getGroupId() == null || group.getGroupId() <= 0L) {
            throw new GroupExceptions("Group id is invalid");
        }

        validateGroup(group);

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

    private void validateGroup(Group group) {
        if (group == null) {
            throw new GroupExceptions("Group cannot be null");
        }

        if (isBlank(group.getCode())) {
            throw new GroupExceptions("El código del grupo es obligatorio");
        }

        if (isBlank(group.getName())) {
            throw new GroupExceptions("El nombre del grupo es obligatorio");
        }

        if (group.getCapacity() == null || group.getCapacity() <= 0) {
            throw new GroupExceptions("La capacidad del grupo debe ser mayor que cero");
        }

        if (group.getProgramId() == null || group.getProgramId() <= 0L) {
            throw new GroupExceptions("El id del programa es inválido o nulo");
        }

        if (group.getPeriodId() == null || group.getPeriodId() <= 0L) {
            throw new GroupExceptions("El id del período es inválido o nulo");
        }

        if (isBlank(group.getSchedule())) {
            throw new GroupExceptions("El horario del grupo es obligatorio");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}