package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Group;
import cesde.edu.ga.service.GroupService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @PostMapping
    public Group create(@RequestBody Group entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Group update(@PathVariable Long id, @RequestBody Group entity) {
        entity.setGroupId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Group findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Group> findAll() {
        return service.findAll();
    }


}
