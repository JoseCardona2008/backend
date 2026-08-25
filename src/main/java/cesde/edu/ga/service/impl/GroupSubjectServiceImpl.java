package cesde.edu.ga.service.impl;

import cesde.edu.ga.exceptions.GroupSubExceptions;
import cesde.edu.ga.model.GroupSubject;
import cesde.edu.ga.repository.GroupSubjectRepository;
import cesde.edu.ga.service.GroupSubjectService;
import java.util.List;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class GroupSubjectServiceImpl implements GroupSubjectService {
    private final GroupSubjectRepository groupSubjectRepository;
    public GroupSubjectServiceImpl(GroupSubjectRepository groupSubjectRepository) {
        this.groupSubjectRepository = groupSubjectRepository;
    }
    @Override
    public GroupSubject create(GroupSubject groupSubject) {
        if (groupSubject == null) {
            throw new GroupSubExceptions("GroupSubject cannot be null");
        }
        if (isInvalidGroupSubject(groupSubject)) {
            throw new GroupSubExceptions("Invalid GroupSubject data");
        }
        return groupSubjectRepository.create(groupSubject);
    }
    @Override
    public boolean update(GroupSubject groupSubject) {
        if (groupSubject == null) {
            throw new GroupSubExceptions("GroupSubject cannot be null");
        }
        if (groupSubject.getGroupSubjectId() == null || groupSubject.getGroupSubjectId() <= 0L) {
            throw new GroupSubExceptions("GroupSubject id is invalid");
        }
        if (isInvalidGroupSubject(groupSubject)) {
            throw new GroupSubExceptions("Invalid GroupSubject data");
        }
        return groupSubjectRepository.update(groupSubject);
    }
    @Override
    public boolean delete(Long groupSubjectId) {
        if (groupSubjectId == null || groupSubjectId <= 0L) {
            throw new GroupSubExceptions("GroupSubject id is invalid");
        }
        return groupSubjectRepository.delete(groupSubjectId);
    }
    @Override
    public GroupSubject findById(Long groupSubjectId) {
        if (groupSubjectId == null || groupSubjectId <= 0L) {
            throw new GroupSubExceptions("GroupSubject id is invalid");
        }
        GroupSubject groupSubject = groupSubjectRepository.findById(groupSubjectId);
        if (groupSubject == null) {
            throw GroupSubExceptions.noEncontrado(groupSubjectId);
        }
        return groupSubject;
    }
    @Override
    public List<GroupSubject> findAll() {
        return groupSubjectRepository.findAll();
    }
    @Override
    public GroupSubject findByGroupId(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            throw new GroupSubExceptions("Group id is invalid");
        }
        return groupSubjectRepository.findByGroupId(groupId);
    }
    @Override
    public GroupSubject findBySubjectId(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            throw new GroupSubExceptions("Subject id is invalid");
        }
        return groupSubjectRepository.findBySubjectId(subjectId);
    }
    @Override
    public GroupSubject findByTeacherId(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            throw new GroupSubExceptions("Teacher id is invalid");
        }
        return groupSubjectRepository.findByTeacherId(teacherId);
    }
    @Override
    public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || groupId <= 0L) {
            throw new GroupSubExceptions("Group id is invalid");
        }
        if (subjectId == null || subjectId <= 0L) {
            throw new GroupSubExceptions("Subject id is invalid");
        }
        return groupSubjectRepository.existsByGroupIdAndSubjectId(groupId, subjectId);
    }
    private boolean isInvalidGroupSubject(GroupSubject groupSubject) {
        return groupSubject == null
                || groupSubject.getGroupId() == null
                || groupSubject.getGroupId() <= 0L
                || groupSubject.getSubjectId() == null
                || groupSubject.getSubjectId() <= 0L
                || groupSubject.getTeacherId() == null
                || groupSubject.getTeacherId() <= 0L;
    }
}