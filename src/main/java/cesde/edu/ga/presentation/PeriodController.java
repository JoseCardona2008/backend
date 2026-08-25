package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Period;
import cesde.edu.ga.service.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    private final PeriodService service;

    public PeriodController(PeriodService service) {
        this.service = service;
    }

    @PostMapping
    public Period create(@RequestBody Period entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Period update(@PathVariable Long id, @RequestBody Period entity) {
        entity.setPeriodId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Period findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Period> findAll() {
        return service.findAll();
    }

    @GetMapping("/code/{code}")
    public Period findByCode(@PathVariable String code) {
        return service.findByCode(code);
    }
}
