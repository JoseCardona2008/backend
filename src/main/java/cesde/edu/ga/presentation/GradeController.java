package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Grade;
import cesde.edu.ga.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService service;

    public GradeController(GradeService service) {
        this.service = service;
    }

    @PostMapping
    public Grade create(@RequestBody Grade entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Grade update(@PathVariable Long id, @RequestBody Grade entity) {
        entity.setGradeId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Grade findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Grade> findAll() {
        return service.findAll();
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public List<Grade> findByEnrollmentId(@PathVariable Long enrollmentId) {
        return service.findByEnrollmentId(enrollmentId);
    }

    @GetMapping("/group-subject/{groupSubjectId}")
    public List<Grade> findByGroupSubjectId(@PathVariable Long groupSubjectId) {
        return service.findByGroupSubjectId(groupSubjectId);
    }
}
