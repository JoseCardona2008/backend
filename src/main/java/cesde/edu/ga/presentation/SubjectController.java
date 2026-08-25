package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Subject;
import cesde.edu.ga.service.SubjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public Subject create(@RequestBody Subject entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject entity) {
        entity.setSubjectId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Subject> findAll() {
        return service.findAll();
    }

@GetMapping("/code/{code}")
    public Subject findByCode(@PathVariable String code) {
        return service.findByCode(code);
    }
}
