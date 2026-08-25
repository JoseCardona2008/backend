package cesde.edu.ga.repository.impl;

import cesde.edu.ga.model.GroupSubject;
import cesde.edu.ga.repository.GroupSubjectRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GroupSubjectRepositoryInMemory implements GroupSubjectRepository {
    private List<GroupSubject> groupSubjects;
    private Long nextGroupSubjectId;
    public GroupSubjectRepositoryInMemory() {
        this.groupSubjects = new ArrayList<>();
        this.nextGroupSubjectId = 1L;
    }
    @Override
    public GroupSubject create(GroupSubject groupSubject) {
        if (groupSubject == null) {
            return null;
        }
        if (existsByGroupIdAndSubjectId(groupSubject.getGroupId(), groupSubject.getSubjectId())) {
            return null;
        }
        groupSubject.setGroupSubjectId(nextGroupSubjectId++);
        groupSubjects.add(groupSubject);
        return groupSubject;
    }
    @Override
    public boolean existsByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || subjectId == null) {
            return false;
        }
        return findByGroupIdAndSubjectId(groupId, subjectId) != null;
    }
    @Override
    public List<GroupSubject> findAll() {
        return new ArrayList<>(groupSubjects);
    }
    @Override
    public GroupSubject findById(Long groupSubjectId) {
        if (groupSubjectId == null || groupSubjectId <= 0) {
            return null;
        }
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupSubjectId.equals(groupSubject.getGroupSubjectId())) {
                return groupSubject;
            }
        }
        return null;
    }
    @Override
    public GroupSubject findByGroupId(Long groupId) {
        if (groupId == null || groupId <= 0) {
            return null;
        }
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupId.equals(groupSubject.getGroupId())) {
                return groupSubject;
            }
        }
        return null;
    }
    @Override
    public GroupSubject findBySubjectId(Long subjectId) {
        if (subjectId == null || subjectId <= 0) {
            return null;
        }
        for (GroupSubject groupSubject : groupSubjects) {
            if (subjectId.equals(groupSubject.getSubjectId())) {
                return groupSubject;
            }
        }
        return null;
    }
    @Override
    public GroupSubject findByTeacherId(Long teacherId) {
        if (teacherId == null || teacherId <= 0) {
            return null;
        }
        for (GroupSubject groupSubject : groupSubjects) {
            if (teacherId.equals(groupSubject.getTeacherId())) {
                return groupSubject;
            }
        }
        return null;
    }
    @Override
    public boolean update(GroupSubject updatedGroupSubject) {
        if (updatedGroupSubject == null) {
            return false;
        }
        GroupSubject existing = findByGroupIdAndSubjectId(
                updatedGroupSubject.getGroupId(),
                updatedGroupSubject.getSubjectId()
        );
        if (existing != null && !existing.getGroupSubjectId().equals(updatedGroupSubject.getGroupSubjectId())) {
            return false;
        }
        for (int i = 0; i < groupSubjects.size(); i++) {
            if (updatedGroupSubject.getGroupSubjectId().equals(groupSubjects.get(i).getGroupSubjectId())) {
                groupSubjects.set(i, updatedGroupSubject);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(Long groupSubjectId) {
        GroupSubject groupSubject = findById(groupSubjectId);
        if (groupSubject == null) {
            return false;
        }
        groupSubjects.remove(groupSubject);
        return true;
    }
    @Override
    public int count() {
        return groupSubjects.size();
    }
    private GroupSubject findByGroupIdAndSubjectId(Long groupId, Long subjectId) {
        if (groupId == null || subjectId == null) {
            return null;
        }
        for (GroupSubject groupSubject : groupSubjects) {
            if (groupId.equals(groupSubject.getGroupId()) && subjectId.equals(groupSubject.getSubjectId())) {
                return groupSubject;
            }
        }
        return null;
    }
}
