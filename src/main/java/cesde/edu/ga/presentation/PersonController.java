package cesde.edu.ga.presentation;

import cesde.edu.ga.model.Person;
import cesde.edu.ga.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person create(@RequestBody Person entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person entity) {
        entity.setUserId(id);
        service.update(entity);
        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping("/document/{documentNumber}")
    public Person findByDocumentNumber(@PathVariable String documentNumber) {
        return service.findByDocumentNumber(documentNumber);
    }

    @GetMapping("/status/{status}")
    public List<Person> findByStatus(@PathVariable String status) {
        return service.findByStatus(status);
    }
}
