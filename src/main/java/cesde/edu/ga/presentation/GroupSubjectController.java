package cesde.edu.ga.presentation;

import cesde.edu.ga.model.GroupSubject;
import cesde.edu.ga.service.GroupSubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-subjects")
public class GroupSubjectController {

    private final GroupSubjectService service;

    public GroupSubjectController(GroupSubjectService service) {
        this.service = service;
    }

    @PostMapping
    public GroupSubject create(@RequestBody GroupSubject entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public GroupSubject update(@PathVariable Long id, @RequestBody GroupSubject entity) {
        entity.setGroupSubjectId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public GroupSubject findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<GroupSubject> findAll() {
        return service.findAll();
    }

    @GetMapping("/group/{groupId}")
    public GroupSubject findByGroupId(@PathVariable Long groupId) {
        return service.findByGroupId(groupId);
    }

    @GetMapping("/subject/{subjectId}")
    public GroupSubject findBySubjectId(@PathVariable Long subjectId) {
        return service.findBySubjectId(subjectId);
    }

    @GetMapping("/teacher/{teacherId}")
    public GroupSubject findByTeacherId(@PathVariable Long teacherId) {
        return service.findByTeacherId(teacherId);
    }

    @GetMapping("/exists")
    public boolean existsByGroupIdAndSubjectId(@RequestParam Long groupId, @RequestParam Long subjectId) {
        return service.existsByGroupIdAndSubjectId(groupId, subjectId);
    }
}
