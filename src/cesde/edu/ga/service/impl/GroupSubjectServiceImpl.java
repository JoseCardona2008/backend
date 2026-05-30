package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.GroupSubject;
import cesde.edu.ga.repository.GroupSubjectRepository;
import cesde.edu.ga.service.GroupSubjectService;
import java.util.List;

public class GroupSubjectServiceImpl implements GroupSubjectService {

    private final GroupSubjectRepository groupSubjectRepository;

    public GroupSubjectServiceImpl(GroupSubjectRepository groupSubjectRepository) {
        this.groupSubjectRepository = groupSubjectRepository;
    }

    @Override
    public GroupSubject create(GroupSubject groupSubject) {
        if (isInvalidGroupSubject(groupSubject)) {
            return null;
        }
        return groupSubjectRepository.create(groupSubject);
    }

    @Override
    public boolean update(GroupSubject groupSubject) {
        if (isInvalidGroupSubject(groupSubject)
                || groupSubject.getGroupSubjectId() == null
                || groupSubject.getGroupSubjectId() <= 0L) {
            return false;
        }
        return groupSubjectRepository.update(groupSubject);
    }

    @Override
    public boolean delete(Long groupSubjectId) {
        if (groupSubjectId == null || groupSubjectId <= 0L) {
            return false;
        }
        return groupSubjectRepository.delete(groupSubjectId);
    }

    @Override
    public GroupSubject findById(Long groupSubjectId) {
        if (groupSubjectId == null || groupSubjectId <= 0L) {
            return null;
        }
        return groupSubjectRepository.findById(groupSubjectId);
    }

    @Override
    public List<GroupSubject> findAll() {
        return groupSubjectRepository.findAll();
    }

    @Override
    public GroupSubject findByGroupId(Long groupId) {
        if (groupId == null || groupId <= 0L) {
            return null;
        }
        return groupSubjectRepository.findByGroupId(groupId);
    }

    @Override
    public GroupSubject findBySubjectId(Long subjectId) {
        if (subjectId == null || subjectId <= 0L) {
            return null;
        }
        return groupSubjectRepository.findBySubjectId(subjectId);
    }

    @Override
    public GroupSubject findByTeacherId(Long teacherId) {
        if (teacherId == null || teacherId <= 0L) {
            return null;
        }
        return groupSubjectRepository.findByTeacherId(teacherId);
    }

    @Override
    public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || subjectId == null) {
            return false;
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
