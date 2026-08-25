package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Enrollment;
import cesde.edu.ga.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public Enrollment create(@RequestBody Enrollment entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Enrollment update(@PathVariable Long id, @RequestBody Enrollment entity) {
        entity.setEnrollmentId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Enrollment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Enrollment> findAll() {
        return service.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> findByStudentId(@PathVariable Long studentId) {
        return service.findByStudentId(studentId);
    }

    @GetMapping("/group/{groupId}")
    public List<Enrollment> findByGroupId(@PathVariable Long groupId) {
        return service.findByGroupId(groupId);
    }

    @GetMapping("/period/{periodId}")
    public List<Enrollment> findByPeriodId(@PathVariable Long periodId) {
        return service.findByPeriodId(periodId);
    }
}
