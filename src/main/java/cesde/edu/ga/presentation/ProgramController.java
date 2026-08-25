package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Program;
import cesde.edu.ga.service.ProgramService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private final ProgramService service;

    public ProgramController(ProgramService service) {
        this.service = service;
    }

    @PostMapping
    public Program create(@RequestBody Program entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Program update(@PathVariable Long id, @RequestBody Program entity) {
        entity.setProgramId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Program findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Program> findAll() {
        return service.findAll();
    }


}
