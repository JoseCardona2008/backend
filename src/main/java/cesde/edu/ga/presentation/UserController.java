package cesde.edu.ga.presentation;

import cesde.edu.ga.model.User;
import cesde.edu.ga.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(@RequestBody User entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User entity) {
        entity.setUserId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

@GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
}
