package cesde.edu.ga.presentation;

import cesde.edu.ga.model.UserRole;
import cesde.edu.ga.service.UserRoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService service;

    public UserRoleController(UserRoleService service) {
        this.service = service;
    }

    @PostMapping
    public UserRole create(@RequestBody UserRole entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public UserRole update(@PathVariable Long id, @RequestBody UserRole entity) {
        entity.setUserRoleId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public UserRole findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<UserRole> findAll() {
        return service.findAll();
    }

@GetMapping("/user/{userId}")
    public List<UserRole> findByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    @GetMapping("/role/{roleId}")
    public List<UserRole> findByRoleId(@PathVariable Long roleId) {
        return service.findByRoleId(roleId);
    }
}
