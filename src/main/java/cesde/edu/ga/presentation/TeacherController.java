package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Teacher;
import cesde.edu.ga.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setTeacherId(id);
        teacherService.update(teacher);
        return teacher;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @GetMapping
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/document/{documentNumber}")
    public Teacher findByDocumentNumber(@PathVariable String documentNumber) {
        return teacherService.findByDocumentNumber(documentNumber);
    }
}
