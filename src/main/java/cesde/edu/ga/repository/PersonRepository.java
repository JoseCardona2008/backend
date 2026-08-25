package cesde.edu.ga.repository;

import cesde.edu.ga.model.Person;
import java.util.List;

public interface PersonRepository {

    Person create(Person person);

    List<Person> findAll();

    Person findById(Long userId);

    Person findByDocumentNumber(String documentNumber);

    List<Person> findByStatus(String status);

    boolean update(Person person);

    boolean delete(Long userId);

    boolean existsByDocumentNumber(String documentNumber);

    int count();
}
