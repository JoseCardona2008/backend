package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Role;
import cesde.edu.ga.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public Role create(@RequestBody Role entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role entity) {
        entity.setRoleId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Role> findAll() {
        return service.findAll();
    }


}
