package cesde.edu.ga.service;

import cesde.edu.ga.model.Person;
import java.util.List;

public interface PersonService {

    Person create(Person person);

    boolean update(Person person);

    boolean delete(Long userId);

    Person findById(Long userId);

    List<Person> findAll();

    Person findByDocumentNumber(String documentNumber);

    List<Person> findByStatus(String status);

    boolean existsByDocumentNumber(String documentNumber);
}
