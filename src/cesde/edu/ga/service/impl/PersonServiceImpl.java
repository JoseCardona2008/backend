package cesde.edu.ga.service.impl;

import cesde.edu.ga.model.Person;
import cesde.edu.ga.repository.PersonRepository;
import cesde.edu.ga.service.PersonService;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        if (isInvalidPerson(person)) {
            return null;
        }
        return personRepository.create(person);
    }

    @Override
    public boolean update(Person person) {
        if (isInvalidPerson(person)
                || person.getUserId() == null
                || person.getUserId() <= 0L) {
            return false;
        }
        return personRepository.update(person);
    }

    @Override
    public boolean delete(Long userId) {
        if (userId == null || userId <= 0L) {
            return false;
        }
        return personRepository.delete(userId);
    }

    @Override
    public Person findById(Long userId) {
        if (userId == null || userId <= 0L) {
            return null;
        }
        return personRepository.findById(userId);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            return null;
        }
        return personRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Person> findByStatus(String status) {
        if (status == null || status.trim().isBlank()) {
            return List.of();
        }
        return personRepository.findByStatus(status);
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isBlank()) {
            return false;
        }
        return personRepository.existsByDocumentNumber(documentNumber);
    }

    private boolean isInvalidPerson(Person person) {
        return person == null
                || isBlank(person.getDocumentType())
                || isBlank(person.getDocumentNumber())
                || isBlank(person.getFirstName())
                || isBlank(person.getLastName())
                || isBlank(person.getStatus());
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isBlank();
    }
}
